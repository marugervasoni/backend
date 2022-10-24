package test.com.dh.medicamentos.service;

import com.dh.medicamentos.dao.impl.MedicamentoDaoH2;
import com.dh.medicamentos.model.Medicamento;
import com.dh.medicamentos.service.MedicamentoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class MedicamentoServiceTest { //Estos son test de integración, no unitarios.

    private MedicamentoService medicamentoService = new MedicamentoService(new MedicamentoDaoH2());

    @Test
    public  void _1_guardarMedicamento(){
        //DADOS
        Medicamento medicamento = new Medicamento("Ibuprofeno", 123,  "lab123", 1000, 200.0);

        //CUANDO
        medicamentoService.guardar(medicamento);

        //ENTONCES
        Assertions.assertTrue(medicamentoService.buscar(1) != null);

    }

    @Test
    public void _2_traerPorId(){
        Medicamento medicamento = medicamentoService.buscar(1);
        Assertions.assertTrue(medicamento != null);
    }
}
