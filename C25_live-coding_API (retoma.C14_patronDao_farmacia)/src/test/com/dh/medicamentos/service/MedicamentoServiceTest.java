package test.com.dh.medicamentos.service;

import com.company.dao.impl.MedicamentoDaoH2;
import com.company.model.Medicamento;
import com.company.service.MedicamentoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

//3)
//esto para que siga el orden de numeracion de los tests supongo
@TestMethodOrder(MethodOrderer.MethodName.class)
class MedicamentoServiceTest {

    //Estos son test de integración, no unitarios.

    //invocamos el servicio e instanciamos e instanciamos el Daoh2:
    private MedicamentoService medicamentoService =new MedicamentoService(new MedicamentoDaoH2());

    @Test
    public void _1_guardarMedicamento(){
        //DADOS (1 medicamento):
        Medicamento medicamento = new Medicamento(123,"Ibuprofeno","lab123",1000,200.0);

        //CUANDO (servicio guarda el medicamento):
        medicamentoService.guardar(medicamento);

        //ENTONCES (servicio buscar medicamento c id x no debe ser null
        Assertions.assertTrue(medicamentoService.buscar(1) != null);
    }

    @Test
    public void _2_traerPorId(){

        //CUANDO (busco medicamento id x)
        Medicamento medicamento = medicamentoService.buscar(1);
        //ENTONCES (medicamento no debe ser null)
        Assertions.assertTrue(medicamento != null);
    }




}