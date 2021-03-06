package com.eduacsp.cv.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import com.eduacsp.cv.cache.CacheUtil;
import com.eduacsp.cv.helper.CvReturn;
import com.eduacsp.cv.helper.CvVo;
import com.eduacsp.cv.helper.ServerLocation;
import com.eduacsp.cv.modelo.Cv;
import com.eduacsp.cv.modelo.Education;
import com.eduacsp.cv.modelo.EnumIdiom;
import com.eduacsp.cv.modelo.EnumLanguageProficiency;
import com.eduacsp.cv.modelo.Experience;
import com.eduacsp.cv.modelo.Guest;
import com.eduacsp.cv.modelo.Interest;
import com.eduacsp.cv.modelo.Language;
import com.eduacsp.cv.modelo.Person;
import com.eduacsp.cv.modelo.Skill;
import com.eduacsp.cv.repository.CvRepository;
import com.eduacsp.cv.repository.GuestRepository;
import com.eduacsp.cv.util.GetIP;
import com.eduacsp.cv.util.GetLocation;
import com.eduacsp.cv.util.IpUtil;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

@Service
@Qualifier("cvService")
public class CvService{

	@Autowired
	private CvRepository cvRepository;

	@Autowired
	@SuppressWarnings("rawtypes")
	private GuestRepository guestRepository;

	@SuppressWarnings("unchecked")
	public CvReturn getCv(String idiom, HttpServletRequest request){
		CvVo cvVo = new CvVo();
		Cv cv = new Cv();
		List<Cv> listaCv = null;
		List<Person> listaPerson = null;
		CvReturn cvReturn = new CvReturn();
		Person person = new Person();
		SimpleDateFormat formatSDF = null;
		Set<Education> setEducation = null;
		Set<Language> setLanguage = null;
		Set<Experience> setExperience = null;
		Set<Skill> setSkill = null;
		Set<Interest> setInterest = null;
		EnumIdiom enumIdiom = getIdiom(LocaleContextHolder.getLocale(),idiom);
		Cache cacheCv = CacheUtil.getCacheCv();

		if(enumIdiom.equals(EnumIdiom.PORTUGUES)){
			formatSDF = new SimpleDateFormat("MM/yyyy");
		}else if(enumIdiom.equals(EnumIdiom.ENGLISH)){
			formatSDF = new SimpleDateFormat("yyyy-MM");
		}

		Guest guest = insertGuestLog(request,idiom);
		guestRepository.save(guest);

		if(cacheCv.isKeyInCache("listaCv-"+enumIdiom.getValue())
				&& cacheCv.get("listaCv-"+enumIdiom.getValue())!=null){
			listaCv = (List<Cv>) cacheCv.get("listaCv-"+enumIdiom.getValue()).getObjectValue();
		}else{
			listaCv = cvRepository.listarCv(enumIdiom);
			cacheCv.put(new Element("listaCv-"+enumIdiom.getValue(),listaCv));
		}

		if(listaCv!=null && listaCv.size()>0){
			cv = listaCv.get(0);
		}

		if(cacheCv.isKeyInCache("listaPerson-"+enumIdiom.getValue()) 
				&& cacheCv.get("listaPerson-"+enumIdiom.getValue())!=null){
			listaPerson = (List<Person>) cacheCv.get("listaPerson-"+enumIdiom.getValue()).getObjectValue();
		}else{
			listaPerson = cvRepository.listarPerson();
			cacheCv.put(new Element("listaPerson-"+enumIdiom.getValue(),listaPerson));
		}

		if(listaPerson!=null && listaPerson.size()>0){
			person = listaPerson.get(0);
		}

		setEducation = setEducation(cv, formatSDF);
		setExperience = setExperience(cv, formatSDF,enumIdiom);
		setLanguage = setLanguageSkills(cv,enumIdiom);
		setSkill = setSkills(cv);
		setInterest = setInterest(cv);

		cv.setInterest(setInterest);
		cv.setExperience(setExperience);
		cv.setLanguage(setLanguage);
		cv.setEducation(setEducation);
		cv.setSkill(setSkill);
		cvVo.setCv(cv);
		cvVo.setPerson(person);
		cvVo.setExpireDate(getExpireDate());
		cvVo.setLocale(enumIdiom.getValue());

		cvReturn.setCvVo(cvVo);
		cvReturn.setEnumIdiom(enumIdiom);

		return cvReturn;
	}

	public Guest insertGuestLog(HttpServletRequest request, String idiom){
		Guest guest = new Guest();
		ServerLocation geoLocation = getGeoLocation(GetIP.getIP(request));

		guest.setIpAddress(GetIP.getIP(request));
		guest.setReferer(IpUtil.getReferer(request));
		guest.setUserAgent(IpUtil.getUserAgent(request));
		if(idiom==null){
			guest.setIdiom(EnumIdiom.PORTUGUES.getValue());
		}else{
			guest.setIdiom(idiom);
		}
		guest.setDateInsert(Calendar.getInstance());
		guest.setCountry(geoLocation.getCountryName());
		guest.setCity(geoLocation.getCity());
		guest.setRegion(geoLocation.getRegion());

		return guest;
	}


	public EnumIdiom getIdiom(Locale locale, String idiom) {
		EnumIdiom idiomReturn = null;
		Locale localeBrasil = new Locale("pt","BR","");
		Locale localePortugal = new Locale("pt","PT","");

		if(idiom==null || (!EnumIdiom.PORTUGUES.getValue().equals(idiom) && !EnumIdiom.ENGLISH.getValue().equals(idiom))){
			if(locale==null || localeBrasil.equals(locale) || localePortugal.equals(locale)){
				idiomReturn = EnumIdiom.PORTUGUES;
			}else{
				idiomReturn = EnumIdiom.ENGLISH;
			}
		}else{
			if(EnumIdiom.PORTUGUES.getValue().equals(idiom)){
				idiomReturn = EnumIdiom.PORTUGUES;
			}else if(EnumIdiom.ENGLISH.getValue().equals(idiom)){
				idiomReturn = EnumIdiom.ENGLISH;
			}
		}
		return idiomReturn;
	}

	private Set<Interest> setInterest(Cv cv) {
		List<Interest> listInterest = null;
		Set<Interest> setInterest = null;

		if(cv.getInterest()!=null){
			listInterest = new ArrayList<Interest>(cv.getInterest());
			listInterest.sort(Comparator.comparing(p -> p.getName()));
			setInterest = new LinkedHashSet<Interest>(listInterest);
		}else{
			setInterest = new LinkedHashSet<Interest>();
		}
		return setInterest;
	}


	private Set<Language> setLanguageSkills(Cv cv,EnumIdiom idiom) {
		Set<Language> setLanguage = null;
		List<Language> listLanguage = new ArrayList<Language>();

		if(cv.getLanguage()!=null){
			for (Language language : cv.getLanguage()) {
				if(idiom.equals(EnumIdiom.PORTUGUES)){
					if(language.getEnumLanguageProficiency().equals(EnumLanguageProficiency.NATIVE)){
						language.setLanguageProficiency("Nativo");
					}else if(language.getEnumLanguageProficiency().equals(EnumLanguageProficiency.FLUENT)){
						language.setLanguageProficiency("Fluente");
					}else if(language.getEnumLanguageProficiency().equals(EnumLanguageProficiency.TECHNICAL)){
						language.setLanguageProficiency("Técnico");
					}else if(language.getEnumLanguageProficiency().equals(EnumLanguageProficiency.PROFESSIONAL)){
						language.setLanguageProficiency("Profissional");
					}
				}else{
					language.setLanguageProficiency(language.getEnumLanguageProficiency().getValue());
				}

				listLanguage.add(language);
			}

			listLanguage.sort(Comparator.comparing(p -> p.getName()));

			setLanguage = new LinkedHashSet<Language>(listLanguage);

		}else{
			setLanguage = new LinkedHashSet<Language>();
		}

		return setLanguage;
	}


	private Set<Education> setEducation(Cv cv, SimpleDateFormat formatSDF) {
		Set<Education> setEducation = new HashSet<Education>();

		if(cv.getEducation()!=null){
			for (Education education : cv.getEducation()) {
				if(education.getFromDate()!=null){
					education.setFromDateF(formatSDF.format(education.getFromDate()));
				}
				if(education.getToDate()!=null){
					education.setToDateF(formatSDF.format(education.getToDate()));
				}
				setEducation.add(education);
			}
		}

		return setEducation;
	}


	private Set<Experience> setExperience(Cv cv, SimpleDateFormat formatSDF, EnumIdiom idiom) {
		List<Experience> listExperience = new ArrayList<Experience>();
		Set<Experience> setExperience = null;

		if(cv.getExperience()!=null){
			for (Experience experience : cv.getExperience()) {
				experience.setFromDateF(formatSDF.format(experience.getFromDate()));
				experience.setToDateF(formatSDF.format(experience.getToDate()));
				if(idiom.equals(EnumIdiom.PORTUGUES)){
					experience.setUntilNowIdiom("até o momento");
				}else if(idiom.equals(EnumIdiom.ENGLISH)){
					experience.setUntilNowIdiom("until now");
				}
				listExperience.add(experience);
			}

			Collections.sort(listExperience,new Comparator<Experience>() {
				@Override
				public int compare(Experience a, Experience b) {
					if(a.getToDate().getTime() < b.getToDate().getTime()){
						return 1;
					}else if(a.getToDate().getTime() > b.getToDate().getTime()){
						return -1;
					}else{
						return 0;
					}
				}
			});

			setExperience = new LinkedHashSet<Experience>(listExperience);
		}else{
			setExperience = new LinkedHashSet<Experience>();
		}

		return setExperience;
	}


	private Set<Skill> setSkills(Cv cv) {
		List<Skill> listSkill = null;
		Set<Skill> setSkill = null;

		if(cv.getSkill()!=null){
			listSkill = new ArrayList<Skill>(cv.getSkill());

			Collections.sort(listSkill,new Comparator<Skill>() {
				@Override
				public int compare(Skill a, Skill b) {
					if(a.getPercent() < b.getPercent()){
						return 1;
					}else if(a.getPercent() > b.getPercent()){
						return -1;
					}else{
						return 0;
					}
				}
			});

			setSkill = new LinkedHashSet<Skill>(listSkill);
		}else{
			setSkill = new LinkedHashSet<Skill>();
		}

		return setSkill;
	}

	/*	public static CvService getInstance(){
		return INSTANCE;
	}*/

	private String getExpireDate(){
		String dtStr = "";//Mon, 22 jul 2006 11:12:01 GMT
		Date dt = new Date();
		Calendar c = Calendar.getInstance(); 
		c.setTime(dt); 
		c.add(java.util.Calendar.DATE, 7);
		dt = c.getTime();
		dtStr = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss").format(dt);
		return dtStr+" GMT";
	}

	private ServerLocation getGeoLocation(String ip){
		GetLocation geoLocation = new GetLocation();

		ServerLocation serverLocation = geoLocation.getLocation(ip);

		return serverLocation;
	}




}
