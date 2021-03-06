package news.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import news.model.dao.ActivityDAOHbm;

import org.apache.tomcat.util.codec.binary.Base64;





public class ActivityService {
	private ActivityDAO activityDao = new ActivityDAOHbm();
	//base乾淨只轉換了圖
	public List<ActivityVO> base(List<ActivityVO> vo){
		List<ActivityVO> bean = new ArrayList<ActivityVO>();
		if (vo != null){
		 for(ActivityVO element : vo) {
			 ActivityVO element1=new ActivityVO();
			 SimpleDateFormat dd = new SimpleDateFormat("yyyyMMddHHmm");
			 element1.setNo(element.getNo());
			 element1.setName(element.getName());
			 element1.setContent(element.getContent());
			 element1.setStartTime(element.getStartTime());
			 element1.setEndTime(element.getEndTime());
			 element1.setEndTime1(dd.format(element.getEndTime()));
			 element1.setAddress(element.getAddress());
			 element1.setPicture1(Base64.encodeBase64String(element.getPicture()));
			 element1.setUrl(element.getUrl());
			 element1.setBoss(element.getBoss());
		     bean.add(element1);
		 }
		}
		return bean;
	}
	
	public List<ActivityVO> base1(List<ActivityVO> vo){
		List<ActivityVO> bean = new ArrayList<ActivityVO>();
		if (vo != null){
		 for(ActivityVO element : vo) {
			 ActivityVO element1=new ActivityVO();
			 element1.setNo(element.getNo());
			 element1.setName(element.getName());
			 if(element.getContent().length()>30){
				String re1 =  element.getContent().substring(0,30);
				System.out.println(re1);
				 element1.setContent("<p>"+ re1 +"</p>");
			 System.out.println(element.getContent());
//				 element1.setContent(element.getContent());
			 	}else{
			 		element1.setContent(element.getContent().substring(0,element.getContent().length()));
			 }
			 element1.setStartTime(element.getStartTime());
			 element1.setEndTime(element.getEndTime());
			 element1.setAddress(element.getAddress());
			 element1.setPicture1(Base64.encodeBase64String(element.getPicture()));
			 if(element.getUrl().length()>30){
			 element1.setUrl(element.getUrl().substring(0,30));
			 }else{
			 		element1.setUrl(element.getUrl().substring(0,element.getUrl().length()));
			 }
			 element1.setBoss(element.getBoss());
		     bean.add(element1);
		 }
		}
		return bean;
	}
	
	
	public List<ActivityVO> fortyContent(List<ActivityVO> vo){
		List<ActivityVO> bean = new ArrayList<ActivityVO>();		
		 for(ActivityVO element : vo) {
			 ActivityVO element1=new ActivityVO();
			 element1.setNo(element.getNo());
			 element1.setName(element.getName());
			 if(element.getContent().length()>40){
				 element1.setContent(element.getContent().substring(0,40));
			 	}else{
			 		element1.setContent(element.getContent().substring(0,element.getContent().length()));
			 }
			 element1.setStartTime(element.getStartTime());
			 element1.setEndTime(element.getEndTime());
			 element1.setAddress(element.getAddress());
			 element1.setPicture1(Base64.encodeBase64String(element.getPicture()));
			 element1.setUrl(element.getUrl());
			 element1.setBoss(element.getBoss());
		     bean.add(element1);
		 }
		return bean;
	}
	
	
	

	public List<ActivityVO> select(ActivityVO vo) {
		List<ActivityVO> result = null;
		if(vo!=null && vo.getNo() !=0) {
			ActivityVO temp = activityDao.selectByPrimaryKey(vo.getNo());
			if(temp!=null) {
				result = new ArrayList<ActivityVO>();
				result.add(temp);
			}
		} else {
			result = activityDao.getAll(); 
		}
		return result;
	}
	
	public List<ActivityVO> findBySname(String aa) {
		List<ActivityVO> result = null;
		if(aa!=null){
			List<ActivityVO> vo = activityDao.findBySname(aa);
			if(vo!=null) {
				result = new ArrayList<ActivityVO>();
				result.addAll(vo);
			}
		}else {
			result = activityDao.getAll(); 
		}return result;
	}
	
	//servlet2
	public ActivityVO selectByPrimaryKey(int no){
		ActivityVO result = null;	

		ActivityVO vo = activityDao.selectByPrimaryKey(no);
		List<ActivityVO> list =new ArrayList<ActivityVO>();
		list.add(vo);
		
		List<ActivityVO> list2 = new ArrayList<ActivityVO>();
		list2 =this.base(list);
		
		ActivityVO bean = (ActivityVO)list2.get(0);
		result=bean;

		return result;
	}

	
	
	public List<java.sql.Timestamp>sawendtime(){
		List<java.sql.Timestamp> result = null;
		List<java.sql.Timestamp> vo = activityDao.sawendtime();
		if(vo!=null) {
			result = new ArrayList<java.sql.Timestamp>();
			result.addAll(vo);
		}
		return result;
	}
	
	public List<String>sawaddress(){
		List<String> result = null;
		List<String> vo = activityDao.sawaddress();
		if(vo!=null) {
				result = new ArrayList<String>();
				result.addAll(vo);
		}
		 return result;		
	}
	
	public String getDateTime(){
		String result = null;
		String firsttime = activityDao.getDateTime();
		String a1 = null;
		String a2 = null;
		String a3 = null;
		String a4 = null;
		String a5 = null;
		a1 = firsttime.substring(0,4);
		a2 = firsttime.substring(5,7);
		a3 = firsttime.substring(8,10);
		a4 = firsttime.substring(11,13);
		a5 = firsttime.substring(14,16);
		String time = a1 + a2 + a3 + a4 +a5;
		result = time;			
		return result;
	}
	
	public List<ActivityVO> selcetall() {	

			List<ActivityVO> list = activityDao.getAll();
			List<ActivityVO> list2 = new ArrayList<ActivityVO>();
			list2 =this.fortyContent(list);
			return list2;
	}
	
	
	public int insert(ActivityVO vo) {
		int result = 0;
		if(vo!=null) {
			result = activityDao.insert(vo);
		}
		return result;
	}
	
	public int update(ActivityVO vo) {
		int result = 0;
		if(vo!=null) {
			result = activityDao.update(vo);
		}
		return result;
	}
	
	public boolean delete(ActivityVO vo) {
		boolean result = false;
		if(vo!=null) {
			result = activityDao.delete(vo.getNo());
		}
		return result;
	}
	
	public static void main(String[] args) {
		ActivityService service = new ActivityService();
		List<ActivityVO> list = service.select(null);
		System.out.println("beans="+list);
	}
	
	//換頁所使用的
	public PagesActivityVO getDatePage(int pageNo, int pageSize){
		List<ActivityVO> list = activityDao.getDatePage(pageNo, pageSize);
					
		int rowCount = activityDao.getDateTotalCount();
		
		PagesActivityVO result = new PagesActivityVO(pageNo, pageSize, rowCount, list);
		
		return result;
	}
}
