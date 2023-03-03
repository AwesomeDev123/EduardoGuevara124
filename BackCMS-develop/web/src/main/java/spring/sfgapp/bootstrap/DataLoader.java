package spring.sfgapp.bootstrap;
import lombok.Builder;
import spring.sfgapp.entity.*;
import spring.sfgapp.enums.eCountry;
import spring.sfgapp.enums.eStatus;
import spring.sfgapp.model.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spring.sfgapp.service.*;
import spring.sfgapp.services.*;
import spring.sfgapp.springdatajpa.*;

import java.time.LocalDate;
/**
 * Created by jt on 7/25/18.
 */
@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final UserService userService;
    private final RegAppService regAppService;
    private final RegPayService regPayService;
    private final RegUserService regUserService;
    private final AppOptService appOptService;

    private final AppTxtService appTxtService;

    private final AppImgService appImgService;
    @Builder
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialtyService specialtyService, UserService userService,
                      RegAppService regAppService, RegPayService regPayService,
                      RegUserService regUserService,AppOptService appOptService,AppTxtService appTxtService,
                      AppImgService appImgService ) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.userService = userService;
        this.regAppService = regAppService;
        this.regPayService = regPayService;
        this.regUserService = regUserService;
        this.appOptService = appOptService;
        this.appTxtService = appTxtService;
        this.appImgService= appImgService;

    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0 ){
            loadData();
            loadData2();
        }
    }

    private void loadData() {

// Tipos de Mascota
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);
// Especialidad
        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialtyService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialtyService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        Speciality savedDentistry = specialtyService.save(dentistry);
// Duenos
        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("1231231234");
// Relacion perros de MIke
        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("123 Brickerel");
        owner2.setCity("Miami");
        owner2.setTelephone("1231231234");
// Relacion perros de Fiona
        Pet fionasCat = new Pet();
        fionasCat.setName("Just Cat");
        fionasCat.setOwner(owner2);
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setPetType(savedCatPetType);
        owner2.getPets().add(fionasCat);

        ownerService.save(owner2);

// Relacion especialidades del veterinario SAM
        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);
// Relacion especialidades del veterinario Jessie
        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }

    private void loadData2() {

        User user = new User();
        user.setFirstName("Name1");
        user.setLastName("LastName1");
        user.setEmailAddress("email@1.com");
        User savedUserUser = userService.save(user);

        User user2 = new User();
        user2.setFirstName("Name2");
        user2.setLastName("LastName2");
        user.setEmailAddress("email@2.com");
        User savedUser2User = userService.save(user2);
        System.out.println("Loaded Users....");

        RegUser regUser = new RegUser();
        regUser.setIdCountry(eCountry.USA);
        regUser.setIdUser("1");
        regUser.setRegUserStatus(eStatus.ACTIVE);
        regUser.setRegUserFrom(LocalDate.ofEpochDay(12-2022));
        regUser.setRegUserTo(LocalDate.ofEpochDay(12-2022));
        RegUser savedRUser = regUserService.save(regUser);


        RegUser regUser2 = new RegUser();
        regUser2.setIdCountry(eCountry.USA);
        regUser2.setIdUser("1");
        regUser2.setRegUserStatus(eStatus.ACTIVE);
        regUser2.setRegUserFrom(LocalDate.ofEpochDay(2-2022));
        regUser2.setRegUserTo(LocalDate.ofEpochDay(12-2022));
        RegUser savedRUser2 = regUserService.save(regUser2);
        System.out.println("Loaded RegUser....");

        RegPay regPay = new RegPay();
        regPay.setPayFrom(LocalDate.ofEpochDay(12-2022));
        regPay.setPayTo(LocalDate.ofEpochDay(12-2022));
        regPay.setPayDoc("9990.9999.99999");
        regPay.setDocDue(LocalDate.ofEpochDay(12-2022));
        regPay.setDocNumber("9990.9999.99999");
        RegPay savedRegistry = regPayService.save(regPay);
        System.out.println("Loaded Payments....");

        RegPay regPay2 = new RegPay();
        regPay.setPayFrom(LocalDate.ofEpochDay(12-2022));
        regPay.setPayTo(LocalDate.ofEpochDay(12-2022));
        regPay.setPayDoc("9990.9999.99999");
        regPay.setDocDue(LocalDate.ofEpochDay(12-2022));
        regPay.setDocNumber("9990.9999.99999");
        RegPay savedRegistry2 = regPayService.save(regPay2);
        System.out.println("Loaded Payments....");

        RegApp regApp = new RegApp();
        regApp.setAppName("kSutra1");
        regApp.setAppStatus(eStatus.ACTIVE);
        regApp.setAppStaFrom(LocalDate.ofEpochDay(10-2022));
        regApp.setAppStaTo(LocalDate.ofEpochDay(12-2022));
        RegApp savedGuides = regAppService.save(regApp);

        RegApp regApp2 = new RegApp();
        regApp.setAppName("kSutra2");
        regApp.setAppStatus(eStatus.ACTIVE);
        regApp.setAppStaFrom(LocalDate.ofEpochDay(10-2022));
        regApp.setAppStaTo(LocalDate.ofEpochDay(12-2022));
        RegApp savedGuides2 = regAppService.save(regApp);

        AppOpt regoption = new AppOpt();
        regoption.setOptName("Cuidados");
        regoption.setOptTitle("Cuidados");
        regoption.setOptSubTitle("Cuidados");
        AppOpt saveoption = appOptService.save(regoption);


        AppOpt regoption2 = new AppOpt();
        regoption2.setOptName("Cuidados Generales");
        regoption2.setOptTitle("Cuidados Generales");
        regoption2.setOptSubTitle("Cuidados Generales");
        AppOpt saveoption2 = appOptService.save(regoption2);

        AppTxt apptxt = new AppTxt();
        apptxt.setAppTxtName("Nombre");
        apptxt.setAppTxtMsg("Mensaje");
        AppTxt saveTxt = appTxtService.save(apptxt);

        AppTxt apptxt2 = new AppTxt();
        apptxt.setAppTxtName("Nombre2");
        apptxt.setAppTxtMsg("Mensaje2");
        AppTxt saveTxt2 = appTxtService.save(apptxt);

        AppImg appimg = new AppImg();
        appimg.setImgName("Nombre IMagen");
        AppImg saveappimg  = appImgService.save(appimg);

        AppImg appimg2 = new AppImg();
        appimg2.setImgName("Nombre IMagen2");
        AppImg saveappimg2  = appImgService.save(appimg2);

    }
}
