import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DeportivoJT extends EventosJT {


    String equipo1;
    String equipo2;
    String tipoDeporte;
    ArrayList<String> arrJugadores = new ArrayList<String>();
    boolean personasIngresadas=false;
   // double totalPagar;


    DeportivoJT(){

    }
    DeportivoJT(int codigo, String tituloDelEvento, String descripcionDelEvento, double montoDePago,String equipo1, String equipo2, String tipoDeporte,int dia, int mes, int año, int tipoEvento, double totalP, String typeUser){
        super(codigo,tituloDelEvento, descripcionDelEvento, montoDePago, dia, mes, año,tipoEvento, totalP,typeUser);
        this.equipo1=equipo1;
        this.equipo2=equipo2;
        this.tipoDeporte=tipoDeporte;
        //totalPagar=montoDePago;


    }
    public void CantidadMaximaPersonas(){
        System.out.println("La cantidad maxima de personas en el evento "+tituloDelEvento+" es de 20 mil personas");

    }
    /*public double getTotalPagar(){
        return totalPagar;
    }*/

    public void setEquipo1(String equipo1){
        this.equipo1=equipo1;
    }
    public void setEquipo2(String equipo2){
        this.equipo2=equipo2;
    }
    public void setTipoDeporte(String tipoDeporte){
        this.tipoDeporte=tipoDeporte;
    }
    public String getEquipo1(){
        return equipo1;
    }
    public String getEquipo2(){
        return equipo2;
    }
    public String getTipoDeporte(){
        return tipoDeporte;
    }

    /*public void totalGanancia(){
        int totalGanancia=0;

        for(int x=0; x<eventos.length;x++){
            if(eventos[x]!=null){
                Date today = new Date();
                Date endDate = eventos[x].fecha;
                if(endDate.after(today)){
                    totalGanancia+=eventos[x].totalPagar;
                }

            }
        }
        System.out.println("Ganancia Total: ");

    }*/



    public EventosJT agregarEvento(int codigo){
        lea.useDelimiter("\n");
        int posicion=posVacia2(0);
        boolean deporte=false;
        EventosJT existe=buscarCodigo(codigo);

        if(posicion==-1){
            System.out.println("Arreglo lleno");
            return null;
        }
        if(existe!=null){
            System.out.println("Ya existe el evento con el codigo "+codigo);
            return null;
        }

        System.out.println("Ingrese el titulo del evento: ");
        String tituloEvent=lea.next();
        System.out.println("Ingrese la descripcion del evento: ");
        String descripcion=lea.next();
        System.out.println("Ingrese el monto de pago: ");
        double montoPago=lea.nextInt();
        System.out.println("Ingrese el DIA que se realizara el evento: ");
        int dia=lea.nextInt();
        System.out.println("Ingrese el MES que se realizara el evento: ");
        int mes=lea.nextInt();
        System.out.println("Ingrese el AÑO que se realizara el evento: ");
        int año=lea.nextInt();
        System.out.println("Ingrese el nombre del equipo 1: ");
        String nombre1=lea.next();
        System.out.println("Ingrese el nombre del equipo 2: ");
        String nombre2=lea.next();

        totalPagar=montoPago;

        do {
            System.out.println("Ingrese el tipo de deporte, FUTBOL, TENIS, RUGBY o BASEBALL ");
            String tipoDeporte2 = lea.next().toLowerCase();

            switch(tipoDeporte2){
                case"futbol":
                    eventos[posicion]=new DeportivoJT(codigo, tituloEvent,descripcion,montoPago, nombre1,nombre2,tipoDeporte2, dia, mes, año, 0,totalPagar,LoginJAVA_TICKET.username);
                    deporte=false;
                    break;
                case "tenis":
                    eventos[posicion]=new DeportivoJT(codigo, tituloEvent,descripcion,montoPago, nombre1,nombre2,tipoDeporte2, dia, mes, año, 0,totalPagar,LoginJAVA_TICKET.username);
                    deporte=false;
                    break;
                case"rugby":
                    eventos[posicion]=new DeportivoJT(codigo, tituloEvent,descripcion,montoPago, nombre1,nombre2,tipoDeporte2, dia, mes, año, 0,totalPagar,LoginJAVA_TICKET.username);
                    deporte=false;
                    break;
                case"baseball":
                    eventos[posicion]=new DeportivoJT(codigo, tituloEvent,descripcion,montoPago, nombre1,nombre2,tipoDeporte2, dia, mes, año,0,totalPagar,LoginJAVA_TICKET.username);
                    deporte=false;
                    break;
                    default:
                        System.out.println("Ingrese solamente una de las opciones");
                        deporte=true;


            }

        }while(deporte);
        //typeUser=LoginJAVA_TICKET.username;
        return eventos[posicion];

    }
    @Override
    public void print(){
        System.out.println("Codigo: "+getCodigo()+"\nTitulo del evento: "+getTituloDelEvento()+"\nDescripcion: "
                +getDescripcionDelEvento()+"\nMonto de Pago: "+getMontoDePago()+ "\nNombre del equipo 1: "+getEquipo1()+ "\nNombre del equipo 2: "+getEquipo2()+"\nTipo de Deporte: "+getTipoDeporte()
                +"\nCancelado: "+isCancelado()+"\nFecha: "+fecha.toString()+"\nTotal a pagar: "+getTotalPagar()+"\nMulta: "+getMulta());
    }

    public void opcionesEditar(){
        lea.useDelimiter("\n");
        boolean error=false;
        boolean deporte=false;
        boolean error2=false;
        do{
            System.out.println("¿Que opciones quieres editar?");
            System.out.println("OPCIONES\n1.Titulo del evento\n2.Descripcion\n3.Monto de pago\n4.Nombre del Equipo 1\n5.Nombre del Equipo 2\n6.Tipo de Deporte\n" +
                    "\nEXTRA\n7. Nombre de los Jugadores");
            int opcion=lea.nextInt();

            switch(opcion) {
                case 1:
                    System.out.println("Ingrese el nuevo Titulo del Evento: ");
                    String tituloN=lea.next();
                    setTituloDelEvento(tituloN);
                    break;
                case 2:
                    System.out.println("Ingrese la nueva Descripcion: ");
                    String descripcionN=lea.next();
                    setDescripcionDelEvento(descripcionN);
                    break;
                case 3:
                    System.out.println("Ingrese el nuevo Monto de Pago: ");
                    double montoN=lea.nextDouble();
                    setMontoDePago(montoN);
                    break;
                case 4:
                    System.out.println("Ingrese el nuevo nombre del Equipo 1: ");
                    String equipo1N=lea.next();
                    setEquipo1(equipo1N);
                    break;
                case 5:
                    System.out.println("Ingrese el nuevo nombre del Equipo 2: ");
                    String equipo2N=lea.next();
                    setEquipo2(equipo2N);
                    break;
                case 6:
                    do {
                        System.out.println("Ingrese el nuevo Tipo de Deporte, FUTBOL, TENIS, RUGBY o BASEBALL : ");
                        String tipoDepN=lea.next().toLowerCase();

                        switch(tipoDepN){
                            case"futbol":
                                setTipoDeporte("Futbol");
                                deporte=false;
                                break;
                            case "tenis":
                                setTipoDeporte("Tenis");
                                deporte=false;
                                break;
                            case"rugby":
                                setTipoDeporte("Rugby");
                                deporte=false;
                                break;
                            case"baseball":
                                setTipoDeporte("Baseball");
                                deporte=false;
                                break;
                            default:
                                System.out.println("Ingrese solamente una de las opciones");
                                deporte=true;


                        }

                    }while(deporte);

                    break;
                case 7:
                    System.out.println("¿Cuantos jugadores quieres ingresar?");
                    int cantidadJugadores=lea.nextInt();
                    System.out.println("Empiece a ingresar los nombres de los jugadores");

                    String nombreJugador;
                    for(int x=0; x<cantidadJugadores; x++){
                        System.out.println((x+1)+"=");
                        nombreJugador=lea.next();
                        arrJugadores.add(nombreJugador);
                    }

                    System.out.println("Los jugadores que ingresaste son: ");
                    for(int x=0;x<arrJugadores.size();x++) {
                        System.out.println((x+1)+". "+arrJugadores.get(x));
                    }
                    personasIngresadas=true;
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
    @Override
    public void printPersonas(int codigo){
        if(personasIngresadas) {
            System.out.println("Las personas ingresadas: ");
            for (int x = 0; x < arrJugadores.size(); x++) {
                System.out.println((x + 1) + ". " + arrJugadores.get(x));
            }
        }

    }




}
