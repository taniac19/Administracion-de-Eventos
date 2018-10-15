import java.util.ArrayList;

public class MusicalesJT extends EventosJT {

    String tipoDeMusica;
    double seguroGrama= montoDePago*0.30;
    ArrayList<String> arrEquipoMusical = new ArrayList<String>();
    boolean personasIngresadas=false;
   // double totalPagar;


    MusicalesJT(){

    }

    MusicalesJT(int codigo, String tituloDelEvento, String descripcionDelEvento, double montoDePago, String tipoDeMusica,int dia, int mes, int año, int tipoEvento, double totalPagar, String typeUser){
        super(codigo,tituloDelEvento, descripcionDelEvento, montoDePago, dia, mes, año, tipoEvento, totalPagar,typeUser);
        this.tipoDeMusica=tipoDeMusica;
       // totalPagar=montoDePago+seguroGrama;

    }

    public void CantidadMaximaPersonas(){
        System.out.println("La cantidad maxima de personas en el evento "+tituloDelEvento+" es de 25 mil personas");

    }

   /* public double getTotalPagar(){
        return totalPagar;
    }*/
    public void setTipoDeMusica(String tipoDeMusica){
        this.tipoDeMusica=tipoDeMusica;
    }

    public String getTipoDeMusica(){
       return tipoDeMusica;
    }

    public EventosJT agregarEvento(int codigo){
        lea.useDelimiter("\n");
        int posicion=posVacia2(0);
        boolean musica=false;

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
        double montoPag=lea.nextInt();
        System.out.println("Ingrese el DIA que se realizara el evento: ");
        int dia=lea.nextInt();
        System.out.println("Ingrese el MES que se realizara el evento: ");
        int mes=lea.nextInt();
        System.out.println("Ingrese el AÑO que se realizara el evento: ");
        int año=lea.nextInt();

        totalPagar= montoPag+seguroGrama;


        do {
            System.out.println("Ingrese el tipo de musica, POP, ROCK, RAP, CLASICA, REGGEATON ");
            String tipoM = lea.next().toLowerCase();

            switch(tipoM){
                case"pop":
                    eventos[posicion]=new MusicalesJT(codigo, tituloEvent,descripcion,montoPag, tipoM, dia, mes, año,1, totalPagar,LoginJAVA_TICKET.username);
                    musica=false;
                    break;
                case "rock":
                    eventos[posicion]=new MusicalesJT(codigo, tituloEvent,descripcion,montoPag, tipoM, dia, mes, año,1, totalPagar,LoginJAVA_TICKET.username);
                    musica=false;
                    break;
                case"rap":
                    eventos[posicion]=new MusicalesJT(codigo, tituloEvent,descripcion,montoPag, tipoM, dia, mes, año,1, totalPagar,LoginJAVA_TICKET.username);
                    musica=false;
                    break;
                case"clasica":
                    eventos[posicion]=new MusicalesJT(codigo, tituloEvent,descripcion,montoPag, tipoM, dia, mes, año,1, totalPagar,LoginJAVA_TICKET.username);
                    musica=false;
                    break;
                case"reggeaton":
                    eventos[posicion]=new MusicalesJT(codigo, tituloEvent,descripcion,montoPag, tipoM, dia, mes, año,1, totalPagar,LoginJAVA_TICKET.username);
                    musica=false;
                    break;
                default:
                    System.out.println("Ingrese solamente una de las opciones");
                    musica=true;



            }

        }while(musica);

       // typeUser=LoginJAVA_TICKET.username;
        return eventos[posicion];

    }
    @Override
    public void print(){
        System.out.println("Codigo: "+getCodigo()+"\nTitulo del evento: "+getTituloDelEvento()+"\nDescripcion: "
                +getDescripcionDelEvento()+"\nMonto de Pago: "+getMontoDePago()+ "\nTipo de musica: "+getTipoDeMusica()+"\nCancelado: "+isCancelado()+"\nFecha: "
                +fecha.toString()+"\nTotal a pagar: "+getTotalPagar()+"\nMulta: "+getMulta());
    }
    public void opcionesEditar(){
        lea.useDelimiter("\n");
        boolean error=false;
        boolean musica=false;
        boolean error2=false;
        do{
            System.out.println("¿Que opciones quieres editar?");
            System.out.println("Opciones\n1.Titulo del evento\n2.Descripcion\n3.Monto de pago\n4. Tipo de Musica\n");
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
                    do {
                        System.out.println("Ingrese el nuevo tipo de musica, POP, ROCK, RAP, CLASICA, REGGEATON  ");
                        String tipoMusicaN = lea.next().toLowerCase();

                        switch(tipoMusicaN){
                            case"pop":
                                setTipoDeMusica(tipoMusicaN);
                                musica=false;
                                break;
                            case "rock":
                                setTipoDeMusica(tipoMusicaN);
                                musica=false;
                                break;
                            case"rap":
                                setTipoDeMusica(tipoMusicaN);
                                musica=false;
                                break;
                            case"clasica":
                                setTipoDeMusica(tipoMusicaN);
                                musica=false;
                                break;
                            case"reggeaton":
                                setTipoDeMusica(tipoMusicaN);
                                musica=false;
                                break;
                            default:
                                System.out.println("Ingrese solamente una de las opciones");
                                musica=true;



                        }

                    }while(musica);
                    break;
                case 5:
                    System.out.println("¿Cuantas personas quieres ingresar?");
                    int cantidadEquipoMusical=lea.nextInt();
                    System.out.println("Empiece a ingresar los nombres de los musicos");

                    String nombreMusico;
                    for(int x=0; x<cantidadEquipoMusical; x++){
                        System.out.println((x+1)+"=");
                        nombreMusico=lea.next();
                        arrEquipoMusical.add(nombreMusico);
                    }

                    System.out.println("Las personas que ingresaste son: ");
                    for(int x=0;x<arrEquipoMusical.size();x++) {
                        System.out.println((x+1)+". "+arrEquipoMusical.get(x));
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
            for (int x = 0; x < arrEquipoMusical.size(); x++) {
                System.out.println((x + 1) + ". " + arrEquipoMusical.get(x));
            }
        }

    }


}
