package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.ControllerTests;
import guru.springframework.sfgpetclinic.fauxspring.Model;
import guru.springframework.sfgpetclinic.fauxspring.ModelImpl;
import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.map.SpecialityMapService;
import guru.springframework.sfgpetclinic.services.map.VetMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

class VetControllerTest implements ControllerTests {

    VetController vetController;
    VetMapService vetMapService;

    @BeforeEach
    void setUp() {
        vetMapService = new VetMapService(new SpecialityMapService());
        vetController = new VetController(vetMapService);

        Speciality nurse = new Speciality(1L, "Helping to the doctor");
        Speciality doctor = new Speciality(2L, "Healing the sicked animals");
        Speciality animalPsychologist = new Speciality(3L, "Psychologically helping to the sicked animals ");

        Vet nurseVet = new Vet(1L, "Joanna", "Jackson", new HashSet<>(Arrays.asList(nurse, animalPsychologist)));
        Vet doctorVet = new Vet(2L, "Mary", "Hamilton", new HashSet<>(Collections.singletonList(doctor)));

        vetMapService.save(nurseVet);
        vetMapService.save(doctorVet);
    }

    @Test
    void listVets() {
        Model model = new ModelImpl();
        String returnedValue = vetController.listVets(model);

        assertThat(returnedValue).isEqualTo("vets/index");
        assertThat(((ModelImpl) model).getModelMap().entrySet()).size().isEqualTo((1));
        assertThat(((ModelImpl) model).getModelMap().get("vets")).size().isEqualTo((2));
    }
}