package com.ledao.controller;

import com.ledao.entity.*;
import com.ledao.service.*;
import com.ledao.util.DateUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 客户宠物Controller层
 *
 * @author LeDao
 * @company
 * @create 2020-02-02 16:12
 */
@Controller
@RequestMapping("/pet")
public class PetController {

    @Value("${petImageFilePath}")
    private String petImageFilePath;

    @Resource
    private PetService petService;

    @Resource
    private ReturnVisitService returnVisitService;

    @Resource
    private AssayService assayService;

    @Resource
    private FosterCareService fosterCareService;

    @Resource
    private MedicalRecordService medicalRecordService;

    @Resource
    private VaccineService vaccineService;

    /**
     * 添加或者修改宠物信息
     *
     * @param pet
     * @return
     */
    @RequestMapping("/save")
    public String save(HttpSession session, Pet pet, @RequestParam("petImage") MultipartFile file) throws Exception {
        if (!file.isEmpty()) {
            if (pet.getId() != null) {
                FileUtils.deleteQuietly(new File(petImageFilePath + petService.findById(pet.getId()).getImageName()));
            }
            // 获取上传的文件名
            String fileName = file.getOriginalFilename();
            // 获取文件的后缀
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            String newFileName = DateUtil.getCurrentDateStr2() + suffixName;
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File(petImageFilePath + newFileName));
            pet.setImageName(newFileName);
        }
        if (pet.getId() == null) {
            pet.setCustomer((Customer) session.getAttribute("currentCustomer"));
            petService.add(pet);
        } else {
            String petName1 = petService.findById(pet.getId()).getName();
            petService.update(pet);
            String petName2 = petService.findById(pet.getId()).getName();
            if (!petName1.equals(petName2)) {
                Map<String, Object> map = new HashMap<>(16);
                map.put("petName2", petName1);
                List<ReturnVisit> returnVisitList = returnVisitService.list(map);
                for (ReturnVisit returnVisit : returnVisitList) {
                    returnVisit.setPetName(petName2);
                    returnVisitService.update(returnVisit);
                }
                List<Assay> assayList = assayService.list(map);
                for (Assay assay : assayList) {
                    assay.setPetName(petName2);
                    assayService.update(assay);
                }
                List<FosterCare> fosterCareList = fosterCareService.list(map);
                for (FosterCare fosterCare : fosterCareList) {
                    fosterCare.setPetName(petName2);
                    fosterCareService.update(fosterCare);
                }
                List<MedicalRecord> medicalRecordList = medicalRecordService.list(map);
                for (MedicalRecord medicalRecord : medicalRecordList) {
                    medicalRecord.setPetName(petName2);
                    medicalRecordService.update(medicalRecord);
                }
                List<Vaccine> vaccineList = vaccineService.list(map);
                for (Vaccine vaccine : vaccineList) {
                    vaccine.setPetName(petName2);
                    vaccineService.update(vaccine);
                }
            }
        }
        return "redirect:/customer/myPet/list/1";
    }

    /**
     * 删除宠物信息
     *
     * @param petId
     * @return
     */
    @RequestMapping("/deletePet")
    public String delete(Integer petId) {
        if (petService.findById(petId).getImageName() != null) {
            FileUtils.deleteQuietly(new File(petImageFilePath + petService.findById(petId).getImageName()));
        }
        petService.delete(petId);
        return "redirect:/customer/myPet/list/1";
    }
}
