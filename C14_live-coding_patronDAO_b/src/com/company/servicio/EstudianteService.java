package com.company.servicio;

import com.company.dao.IDao;
import com.company.entidades.Estudiante;

import java.util.List;

//3) creo clase de servicio
public class EstudianteService {

    //atributo: la interface Dao de tipo Estudiante:
    private IDao<Estudiante> estudianteIDao;

    //getters y setters
    public IDao<Estudiante> getEstudianteIDao() {
        return estudianteIDao;
    }
    public void setEstudianteIDao(IDao<Estudiante> estudianteIDao) {
        this.estudianteIDao = estudianteIDao;
    }

    //metodos --> delegaran la respons a EstudianteIDao:
    public Estudiante guardarEstudiante(Estudiante e) { //me devuelve estudiante
        return estudianteIDao.guardar(e);
     }

     public void eliminarEstudiante(Long id) {
         estudianteIDao.eliminar(id);
     }

     public Estudiante buscarEstudiante(Long id){
        return estudianteIDao.buscar(id);
     }

     public List<Estudiante> buscarTodos(){
        return estudianteIDao.buscarTodos();
     }



}
