/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component;

import design.IUsuarioAsignaturaDAO;
import java.sql.Connection;

/**
 *
 * @author isaac
 */
public class UsuarioAsignaturaDAO implements IUsuarioAsignaturaDAO{
    private Connection connection;
    public UsuarioAsignaturaDAO(Connection connection) {
        this.connection=connection;
    }
    
}
