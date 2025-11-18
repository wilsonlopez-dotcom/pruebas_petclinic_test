package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Vet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class VetServiceTest {

    @Autowired
    private VetService vetService;

    @Test
    public void testCreateVet() {
        Vet vet = new Vet();
        vet.setFirstName("Carlos");
        vet.setLastName("Gomez");
        vet.setEmail("carlos@vet.com");
        vet.setPhone("999888777");
        vet.setActive(true);

        Vet saved = vetService.create(vet);
        assertNotNull(saved.getId());
    }

    @Test
    public void testUpdateVet() {
        Vet vet = new Vet();
        vet.setFirstName("Ana");
        vet.setLastName("Lopez");
        vet.setEmail("ana@vet.com");
        vet.setPhone("999777666");
        vet.setActive(true);
        
        Vet saved = vetService.create(vet);
        saved.setEmail("ana.nueva@vet.com");
        
        Vet updated = vetService.update(saved);
        assertEquals("ana.nueva@vet.com", updated.getEmail());
    }

    @Test
    public void testFindVetById() {
        Vet vet = new Vet();
        vet.setFirstName("Luis");
        vet.setLastName("Martinez");
        vet.setEmail("luis@vet.com");
        vet.setPhone("999666555");
        vet.setActive(true);
        
        Vet saved = vetService.create(vet);
        Vet found = vetService.findById(saved.getId()).orElse(null);
        
        assertNotNull(found);
        assertEquals("Luis", found.getFirstName());
    }

    @Test
    public void testDeleteVet() {
        Vet vet = new Vet();
        vet.setFirstName("Maria");
        vet.setLastName("Torres");
        vet.setEmail("maria@vet.com");
        vet.setPhone("999555444");
        vet.setActive(true);
        
        Vet saved = vetService.create(vet);
        Long id = saved.getId();
        
        vetService.delete(id);
        
        assertFalse(vetService.findById(id).isPresent());
    }
    @Test
    public void testFindAllVets() {
        // Crear 3 vets
        Vet vet1 = new Vet();
        vet1.setFirstName("Pedro");
        vet1.setLastName("Sanchez");
        vet1.setEmail("pedro@vet.com");
        vet1.setPhone("111222333");
        vet1.setActive(true);
        vetService.create(vet1);
        
        Vet vet2 = new Vet();
        vet2.setFirstName("Sofia");
        vet2.setLastName("Ramirez");
        vet2.setEmail("sofia@vet.com");
        vet2.setPhone("444555666");
        vet2.setActive(true);
        vetService.create(vet2);
        
        Vet vet3 = new Vet();
        vet3.setFirstName("Diego");
        vet3.setLastName("Flores");
        vet3.setEmail("diego@vet.com");
        vet3.setPhone("777888999");
        vet3.setActive(true);
        vetService.create(vet3);
        
        // Buscar todos
        assertTrue(vetService.findAll().size() >= 3);
    }

    @Test
    public void testUpdateVetPhone() {
        Vet vet = new Vet();
        vet.setFirstName("Roberto");
        vet.setLastName("Cruz");
        vet.setEmail("roberto@vet.com");
        vet.setPhone("111111111");
        vet.setActive(true);
        
        Vet saved = vetService.create(vet);
        saved.setPhone("999999999");
        
        Vet updated = vetService.update(saved);
        assertEquals("999999999", updated.getPhone());
    }

    @Test
    public void testDeleteMultipleVets() {
        // Crear 3 vets
        Vet vet1 = new Vet();
        vet1.setFirstName("Julia");
        vet1.setLastName("Morales");
        vet1.setEmail("julia@vet.com");
        vet1.setPhone("222333444");
        vet1.setActive(true);
        Vet saved1 = vetService.create(vet1);
        
        Vet vet2 = new Vet();
        vet2.setFirstName("Miguel");
        vet2.setLastName("Vargas");
        vet2.setEmail("miguel@vet.com");
        vet2.setPhone("555666777");
        vet2.setActive(true);
        Vet saved2 = vetService.create(vet2);
        
        Vet vet3 = new Vet();
        vet3.setFirstName("Carmen");
        vet3.setLastName("Rojas");
        vet3.setEmail("carmen@vet.com");
        vet3.setPhone("888999000");
        vet3.setActive(true);
        Vet saved3 = vetService.create(vet3);
        
        // Eliminar los 3
        vetService.delete(saved1.getId());
        vetService.delete(saved2.getId());
        vetService.delete(saved3.getId());
        
        // Verificar eliminación
        assertFalse(vetService.findById(saved1.getId()).isPresent());
        assertFalse(vetService.findById(saved2.getId()).isPresent());
        assertFalse(vetService.findById(saved3.getId()).isPresent());
    }

    @Test
    public void testFindVetByIdNotFound() {
        Long idInexistente = 99999L;
        assertFalse(vetService.findById(idInexistente).isPresent());
    }
}