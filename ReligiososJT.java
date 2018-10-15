import java.util.ArrayList;

public class ReligiososJT extends EventosJT {
    ArrayList<String> arrConvertidos = new ArrayList<String>();
    final int seguroGrama=2000;
    boolean personasIngresadas=false;
    //double totalPagar;


    ReligiososJT(){

    }

    ReligiososJT(int codigo, String tituloDelEvento, String descripcionDelEvento, double montoDePago,int dia, int mes, int año, int tipoEvento, double totalPagar, String typeUser){
        super(codigo,tituloDelEvento, descripcionDelEvento, montoDePago, dia, mes, año, tipoEvento, totalPagar,typeUser);
       // totalPagar=montoDePago+seguroGrama;

    }

   /* public double getTotalPagar(){
        return totalPagar;
    }*/
    public int getSeguroGrama(){
        return seguroGrama;
    }

    public void CantidadMaximaPersonas(){
        System.out.println("La cantidad maxima de personas en el evento "+tituloDelEvento+" es de 20 mil personas");

    }

    public EventosJT agregarEvento(int codigo){
        lea.useDelimiter("\n");
        int posicion=posVacia2(0);
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

        totalPagar=montoPago+seguroGrama;

        eventos[posicion]=new ReligiososJT(codigo, tituloEvent,descripcion,montoPago, dia, mes, año,2,totalPagar,LoginJAVA_TICKET.username);
       // typeUser=LoginJAVA_TICKET.username;
        return eventos[posicion];

    }

    @Override

    public void print(){
        System.out.println("Codigo: "+getCodigo()+"\nTitulo del evento: "+getTituloDelEvento()+"\nDescripcion: "
                +getDescripcionDelEvento()+"\nMonto de Pago: "+getMontoDePago()+ "\nSeguro de la grama: "+getSeguroGrama()+"\nCancelado: "+isCancelado()+"\nFecha: "+fecha.toString()+"\nTotal a pagar: "+getTotalPagar());
    }

    public void opcionesEditar(){
        lea.useDelimiter("\n");
        boolean error2=false;
        boolean error=false;
        do{
            System.out.println("¿Que opciones quieres editar?");
            System.out.println("OPCIONES.\n1.Titulo del evento\n2.Descripcion\n3.Monto de pago\n" +
                    "\nEXTRA\n4.Ingrear las personas Convertidas");
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

                    System.out.println("¿Cuantas personas quieres ingresar?");
                    int cantidadConvertidos=lea.nextInt();
                    System.out.println("Empiece a ingresar los nombres de los Convertidos");

                    String nombreConvertido;
                    for(int x=0; x<cantidadConvertidos; x++){
                        System.out.println((x+1)+"=");
                        nombreConvertido=lea.next();
                        arrConvertidos.add(nombreConvertido);
                    }

                    System.out.println("Las personas que ingresaste son: ");
                    for(int x=0;x<arrConvertidos.size();x++) {
                        System.out.println((x+1)+". "+arrConvertidos.get(x));
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
            for (int x = 0; x < arrConvertidos.size(); x++) {
                System.out.println((x + 1) + ". " + arrConvertidos.get(x));
            }
        }

    }


}
