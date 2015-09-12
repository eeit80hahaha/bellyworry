package calories.model.dao;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import calories.model.MenuVO;

public class test {

	public static void main(String[] args) {

		// *****FoodCalDAOjdbc 測試檔!*****
		// FoodCalVO vo = new FoodCalVO();
		// FoodCalDAO dao = new FoodCalDAOjdbc();
		// FoodCalDAOHbm hbm = new FoodCalDAOHbm();

		// // selectByPrimaryKey
		// vo = dao.selectByPrimaryKey(100009);
		// vo = hbm.selectByPrimaryKey(100009);
		// System.out.println(vo);

		// // select_ALL
		// System.out.println(dao.getAll());
		// System.out.println(hbm.getAll());

		// // INSERT
		File file = new File("C:/Users/Kuei/Desktop/1.jpg");
		FileInputStream fis = null;
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		int read;
		byte[] data = new byte[1024];
		try {
			fis = new FileInputStream(file);
			while ((read = fis.read(data, 0, data.length)) != -1) {
				buffer.write(data, 0, read);
			}
			buffer.flush();
		} catch (IOException e) {

			e.printStackTrace();
		}

		// vo.setName("松果");
		// vo.setMenuNo(100007);
		// vo.setCal(38);
		// vo.setCount("顆");
		// vo.setWeight(102);
		// vo.setCookNo(100001);
		// vo.setPicture(buffer.toByteArray());
		// System.out.println(hbm.insert(vo));
		// System.out.println(dao.insert(vo,null,0));
		// System.out.println(dao.selectByPrimaryKey(100018));

		// vo.setName("2美式2");
		// vo.setMenuNo(100018);
		// vo.setCal(2);
		// vo.setCount("杯");
		// vo.setWeight(240);
		// vo.setCookNo(100003);
		// vo.setPicture(null);
		// System.out.println(hbm.insert(vo));
		// System.out.println(dao.insert(vo,null,0));
		// System.out.println(dao.selectByPrimaryKey(100001));

		// // UPDATE
		// vo.setFoodNo(100026);
		// vo.setName("大叔好雷");
		// vo.setMenuNo(100013);
		// vo.setCal(99);
		// vo.setCount("碗");
		// vo.setWeight(300);
		// vo.setCookNo(100004);
		// vo.setPicture(buffer.toByteArray());
		// System.out.println(hbm.update(vo));
		// System.out.println(dao.update(vo));

		// // DELETE
		// System.out.println(dao.delete(100008));
		// System.out.println(hbm.delete(100025));

		// =========================================================

		// *****MenuDaoJdbc 測試檔!*****
		// MenuDaoJdbc temp=new MenuDaoJdbc();
		// System.out.println(temp.selectByPrimaryKey(100015));
		// MenuDaoHbm temp=new MenuDaoHbm();
		// System.out.println(temp.selectByPrimaryKey(100001));
		// System.out.println(temp.getAll());
		// MenuVO temp1=new MenuVO();
		// temp1.setMenuNo(100019);
		// temp1.setName("類");
		// temp1.setMenuNo(100004);
		// temp1.setName("測試1");
		// System.out.println(temp.insert(temp1));
		// System.out.println(temp.update(temp1));
		// System.out.println(temp.delete(100019));

		// =========================================================

		// *****ExerciseCalDaoJdbc 測試檔!*****
		// ExerciseCalDaoJdbc test=new ExerciseCalDaoJdbc();
		// ExerciseCalDaoHbm test=new ExerciseCalDaoHbm();
		// System.out.println(test.selectByPrimaryKey(100001));
		// System.out.println(test.getAll());
		// ExerciseCalVO test1=new ExerciseCalVO();
		// test1.setName("千球4");
		// test1.setName("鉛球11");
		// test1.setCalHour( 50.7F);//why 要型別轉換?
		// test1.setExerciseNo(100008);
		// test1.setExerciseNo(100007);
		// System.out.println(test.insert(test1));
		// System.out.println(test.update(test1));
		// System.out.println(test.delete(100008));

		// =========================================================

	}

}
