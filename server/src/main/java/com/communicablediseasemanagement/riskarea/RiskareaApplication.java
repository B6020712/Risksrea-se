package com.communicablediseasemanagement.riskarea;

import com.communicablediseasemanagement.riskarea.entity.*;
import com.communicablediseasemanagement.riskarea.repository.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class RiskareaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RiskareaApplication.class, args);
	}

	@Bean
    ApplicationRunner init( Provincerepository provincerepository, 
                            Diseaserepository diseaserepository, 
                            Communicablelevelrepository communicablelevelrepository) {
		return args -> {
			Stream.of("เชียงราย", "เชียงใหม่", "น่าน", "พะเยา", "แพร่", "แม่ฮ่องสอน", "ลำปาง", "ลำพูน", "อุุตรดิตถ์",
					"กาฬสินธุ์", "ขอนแก่น", "ชัยภูมิ", "นครพนม", "นครราชสีมา", "บึงกาฬ", "บุรีรัมย์", "มหาสารคาม",
					"มุกดาหาร", "ยโสธร", "ร้อยเอ็ด", "เลย", "สกลนคร", "สุรินทร์", "ศรีสะเกษ", "หนองคาย", "หนองบัวลำภู",
					"อุดรธานี", "อุบลราชธานี", "อำนาจเจริญ", "กำแพงเพชร", "ชัยนาท", "นครนายก", "นครปฐม", "นครสวรรค์",
					"นนทบุรี", "ปทุมธานี", "พระนครศรีอยุธยา", "พิจิตร", "พิษณุโลก", "เพชรบูรณ์", "ลพบุรี",
					"สมุทรปราการ", "สมุทรสงคราม", "สมุทรสาคร", "สิงห์บุรี", "สุโขทัย", "สุพรรณบุรี", "สระบุรี",
					"อ่างทอง", "อุทัยธานี", "จันทบุรี", "ฉะเชิงเทรา", "ชลบุรี", "ตราด", "ปราจีนบุรี", "ระยอง",
					"สระแก้ว", "กาญจนบุรี", "ตาก", "ประจวบคีรีขันธ์", "เพชรบุรี", "ราชบุรี", "กระบี่", "ชุมพร", "ตรัง",
					"นครศรีธรรมราช", "นราธิวาส", "ปัตตานี", "พังงา", "พัทลุง", "ภูเก็ต", "ระนอง", "สตูล", "สงขลา",
					"สุราษฏร์ธานี", "ยะลา", "กรุงเทพมหานครฯ").forEach(newprovince -> {
						Province province = new Province();
						province.setProvince(newprovince);
						provincerepository.save(province);
					});

			Stream.of("โรคไข้เหลือง", "โรคเอดส์", "โรคไข้เลือดออก", "โรคไก่ทอด").forEach(newdisease -> {
				Disease disease = new Disease(); 
				disease.setDisease(newdisease); 
				diseaserepository.save(disease); 
			});

			Stream.of(	"ระบาดเล็กน้อย (น้อยกว่า 10 คน)", 
						"ระบาดปานกลาง (ระหว่าง 10 - 30 คน)",
						"ระบาดระดับเฝ้าะวัง (ระหว่าง 30 - 50 คน)",
						"ระบาดรุนแรง (ตั้งแต่ 51 คนขึ้นไป)").forEach(newcommunicablelevel -> {
				Communicablelevel communicablelevel = new Communicablelevel();
				communicablelevel.setCommunicablelevel(newcommunicablelevel); 
				communicablelevelrepository.save(communicablelevel); 
			});

			provincerepository.findAll().forEach(System.out::println);
			diseaserepository.findAll().forEach(System.out::println);
			communicablelevelrepository.findAll().forEach(System.out::println); 
		};
	}
}