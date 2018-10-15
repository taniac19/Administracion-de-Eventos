import java.util.Scanner;

public class LoginJAVA_TICKET {

    //static UsersJT users[] = new UsersJT[100];
    static boolean incorrecto=false;
    static String username;
    static UsersJT user= new UsersJT("super", "admin", "administrador", "administrador", 0);




    public static Scanner lea= new Scanner(System.in);


    public static boolean ingreso(String us,String pass){

        for (int i = 0;i<user.usuarios.length;i++){

            if(user.usuarios[i]!=null && user.usuarios[i].getUserName().equals(us) && user.usuarios[i].getPassword().equals(pass)){
                int p = ingresado (us);
                return true;
            }

        }
        return false;

    }

    public static int ingresado(String users){

        for (int i = 0;i<100;i++){

            if(user.usuarios[i] !=null && user.usuarios[i].getUserName().equals(users)){
                return i;
            }

        }
        return -1;
    }

    public static void ingresar(){

        System.out.println("--------------------------------");

        System.out.println("Ingrese el Username: ");
        username= lea.next();
        System.out.println("Ingrese la contraseña: ");
        String password=lea.next();

        boolean ingresar=ingreso(username,password);

        PrincipalJT menu=new PrincipalJT();

        if(ingresar){
            System.out.println("¡Ingresado correctamente!");
            System.out.println("--------------------------------");
            menu.MenuPrincipal();
            incorrecto=true;
        }else{
            System.out.println("Usuario/Contraseña incorrecto");
            incorrecto=true;
        }

    }

    public static void main(String[] args) {
        user.usuarios[0]= user;
        do {
            ingresar();
        }while(incorrecto);

    }

}
