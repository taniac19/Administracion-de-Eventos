import javax.jws.soap.SOAPBinding;
import java.util.Scanner;

public class UsersJT {
    String password;
    String userName;
    String completeName;
    String typeOfUser;
    int edad;
    public static UsersJT usuarios[]= new UsersJT[100];
    public static Scanner lea= new Scanner(System.in);
    UsersJT(){

    }
    UsersJT(UsersJT arr[]){
        this.usuarios=arr;

    }

    UsersJT(String password, String userName, String completeName, String typeOfUser, int edad){
        this.password=password;
        this.userName=userName;
        this.completeName=completeName;
        this.typeOfUser=typeOfUser;
        this.edad=edad;
    }
     public String getPassword(){
        return password;
     }

    public String getUserName(){
        return userName;
    }

    public String getCompleteName()
    {
        return completeName;
    }

    public String getTypeOfUser(){

        return typeOfUser;
    }

    public int getEdad()
    {
        return edad;
    }

    public void setUserName(String username){
        this.userName=username;
    }
    public void setPassword(String password){

        this.password=password;
    }

    public void setCompleteName(String completeName){

        this.completeName=completeName;
    }

    public void setTypeOfUser(String typeOfUser){
        this.typeOfUser=typeOfUser;
    }

    public void setEdad(int edad){
        this.edad=edad;
    }

     public void print(){
         System.out.println("Nombre del Usuario: "+getCompleteName()+"\nUsername: "+getUserName()+"\nContraseña: "
                 +getPassword()+"\nTipo de Usuario "+getTypeOfUser()+ "\nEdad: "+getEdad());

     }
    public final void verUsuario(String username){
        int existe=buscarCodigo2(username);

        if(existe!=-1){
            usuarios[existe].print();
            verLoggenInEventos();

        } else {
            System.out.println("No existe el codigo");
        }


    }
    //RECURSIVIDAD
    public int Vacia(int posicion){
        if (posicion<usuarios.length && usuarios[posicion] == null) {
            return  posicion;
        }
        else if(posicion<usuarios.length){
            return  Vacia(posicion+1);
        }
        return -1;
    }
/*
    public int posVacia(){
        for(int i=0; i<usuarios.length;i++) {
            if (usuarios[i] == null) {
                return  i;
            }
        }
        return -1;
    }*/

    public UsersJT buscarCodigo(String username){
        for (UsersJT users : usuarios) {
            if(users!=null && users.getUserName().equals(username)){
                return users;
            }
        }
        return null;
    }

    public int buscarCodigo2(String username){
        for (int x=0; x<usuarios.length;x++) {
            if(usuarios[x]!=null){
                //System.out.println(usuarios[x].getUserName() + " vs " + username);
                if(usuarios[x].getUserName().equals(username))
                    return x;
            }
        }
        return -1;
    }

    public int sacarPosicion(String username){
        for (int x=0; x<usuarios.length;x++) {
            if(usuarios[x]!=null){
                //System.out.println(usuarios[x].getUserName() + " vs " + username);
                if(usuarios[x].getUserName().equals(username))
                    return x;
            }
        }
        return -1;
    }
    public void eliminarUsuario(String username){
        int posicion=buscarCodigo2(username);

        if(posicion!=-1){
           usuarios[posicion]=null;
            System.out.println("Eliminado correctamente");
        }else{
            System.out.println("no existe el usuario que desea eliminar");
        }


    }

    public boolean restricciones(String username){
        int posicion=sacarPosicion(username);
        //System.out.println("posicion "+ String.valueOf(posicion));
        if(posicion!=-1) {
            if (usuarios[posicion].typeOfUser.equals("administrador") || usuarios[posicion].typeOfUser.equals("contenidos")) {
                return true;
            } else {
                return false;
            }
        }
            return false;



    }
    public boolean restricciones2(String username){
        int posicion=sacarPosicion(username);
       // System.out.println("posicion "+ String.valueOf(posicion));
        if(posicion!=-1) {
            if (usuarios[posicion].typeOfUser.equals("administrador")) {
                return true;
            } else {
                return false;
            }
        }
        return false;



    }
    public void verLoggenInEventos( ){

      for (int x=0; x<EventosJT.eventos.length;x++) {
          if (EventosJT.eventos[x]!=null && EventosJT.eventos[x].typeUser.equals(LoginJAVA_TICKET.username)) {
              System.out.println("\n");
              EventosJT.eventos[x].print();
          }
      }


    }

    public void opcionesEditar(){

    }




}
