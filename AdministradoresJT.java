import java.util.ArrayList;
import java.util.Scanner;

public class AdministradoresJT extends UsersJT {

    ArrayList<String> idsAdmin = new ArrayList<String>();

    AdministradoresJT(){

    }

    AdministradoresJT(String password, String userName, String completeName, String typeOfUser, int edad){
        super(password,userName,completeName,typeOfUser,edad);
    }

    /*public void ListarUsuarios(){
        System.out.println("Usuarios");
        int cont = 0;
        for (UsersJT x:usuarios) {
            System.out.println("----------Usuario-----------"+String.valueOf(cont));
            if(x != null )
                x.print();
            cont++;
        }
    }*/

    public UsersJT agregarUsuario(String username){
        lea.useDelimiter("\n");

        int posicion=Vacia(0);
        boolean  tipoUsuario=false;
        UsersJT existe=buscarCodigo(username);

        if(posicion==-1){
            System.out.println("Arreglo lleno");
            return null;
        }
        if(existe!=null){
            System.out.println("Ya existe el usuario con el Username "+username);
            return null;
        }

        System.out.println("Ingrese la contraseña: ");
        String contraseña=lea.next();
        System.out.println("Ingrese el Nombre Completo: ");
        String nombreC=lea.next();
        System.out.println("Ingrese la edad: ");
        int edad=lea.nextInt();


        do {
            System.out.println("Ingrese el tipo de Usuario, Administrador, Contenidos o Limitado");
            String tipoU = lea.next().toLowerCase();

            switch(tipoU){
                case"administrador":
                    usuarios[posicion]=new AdministradoresJT(contraseña,username,nombreC,tipoU,edad);
                    tipoUsuario=false;
                    break;
                case "contenidos":
                    usuarios[posicion]=new AdministradoresJT(contraseña,username,nombreC,tipoU,edad);
                    tipoUsuario=false;
                    break;
                case"limitado":
                    usuarios[posicion]=new AdministradoresJT(contraseña,username,nombreC,tipoU,edad);
                    tipoUsuario=false;
                    break;
                default:
                    System.out.println("Ingrese solamente una de las opciones");
                    tipoUsuario=true;

            }

        }while(tipoUsuario);

        //ListarUsuarios();

        return usuarios[posicion];

    }
    public void editarUser(String username){
        int existe=buscarCodigo2(username);

        if(existe!=-1){
            usuarios[existe].print();
            usuarios[existe].opcionesEditar();

        } else {
            System.out.println("No existe la persona con el Username");
        }


    }
    @Override
    public void opcionesEditar(){
        lea.useDelimiter("\n");
        int posicion=Vacia(0);

        boolean  tipoUsuario=false;
        boolean error=false;
        boolean error2=false;

        do{
            System.out.println("¿Que opciones quieres editar?");
            System.out.println("OPCIONES\n1.Contraseña\n2.Nombre Completo\n3.Tipo de Usuario\n4.Edad\n");
            int opcion=lea.nextInt();

            switch(opcion) {
                case 1:
                    System.out.println("Ingrese la nueva contraseña: ");
                    String contraseña=lea.next();
                    setPassword(contraseña);
                    break;
                case 2:
                    System.out.println("Ingrese el nombre completo: ");
                    String nombreC=lea.next();
                    setCompleteName(nombreC);
                    break;
                case 3:
                    do {
                        System.out.println("Ingrese el tipo de Usuario, Administrador, Contenidos o Limitado");
                        String tipoU = lea.next().toLowerCase();

                        switch(tipoU){
                            case"administrador":
                                setTypeOfUser(tipoU);
                                tipoUsuario=false;
                                break;
                            case "contenidos":
                               setTypeOfUser(tipoU);
                                tipoUsuario=false;
                                break;
                            case"limitado":
                                setTypeOfUser(tipoU);
                                tipoUsuario=false;
                                break;
                            default:
                                System.out.println("Ingrese solamente una de las opciones");
                                tipoUsuario=true;

                        }

                    }while(tipoUsuario);
                    break;
                case 4:
                    System.out.println("Ingrese la edad: ");
                    int edad=lea.nextInt();
                    setEdad(edad);

                    break;
                default:
                    System.out.println("Ingrese solamente el numero de las opciones");
                    error=true;
                    break;
            }
            do {

                System.out.println("¿Quieres editar otra opcion?");
                String siNo = lea.next().toLowerCase();

                switch (siNo) {
                    case "si":
                        error=true;
                        error2=false;
                        break;
                    case "no":
                        error=false;
                        error2=false;
                        break;
                    default:
                        error2=true;
                        break;
                }

            }while(error2);
        }while(error);
    }
}
