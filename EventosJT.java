import javax.print.attribute.standard.DateTimeAtCreation;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public abstract class EventosJT {

    static EventosJT eventos[] = new EventosJT[100];

    public static Scanner lea = new Scanner(System.in);
    boolean cancelado;

    String typeUser;
    int codigo;
    String tituloDelEvento;
    String descripcionDelEvento;
    Date fecha = new Date();
    int dia;
    int mes;
    int año;
    SimpleDateFormat dformat = new SimpleDateFormat("MM/dd/yyyy");
    double montoDePago;

    double totalPagar;
    int tipo;
    double multa;

    EventosJT() {

    }

    EventosJT(int codigo, String tituloDelEvento, String descripcionDelEvento, double montoDePago, int dia, int mes, int año, int tipoEvento, double totalPagar, String typeUser) {
        this.codigo = codigo;
        this.tituloDelEvento = tituloDelEvento;
        this.descripcionDelEvento = descripcionDelEvento;
        // this.fecha=fecha;//PASARLO A DATE
        this.montoDePago = montoDePago;
        this.cancelado = false;
        this.dia = dia;
        this.mes = mes;
        this.año = año;
        this.tipo = tipoEvento;
        this.totalPagar=totalPagar;
        this.typeUser=typeUser;
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = String.valueOf(dia) + "/" + String.valueOf(mes) + "/" + String.valueOf(año);
        Date dataFrom;
        try {
            dataFrom = df.parse(strDate);
        } catch (Exception e) {
            System.out.println("Error ingresando fecha: "+e.getMessage());
            dataFrom = new Date();
        }

        this.fecha = dataFrom;

    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }

    public double getTotalPagar(){
        return totalPagar;
    }

    public double getMulta(){
        return multa;
    }

    public boolean isCancelado() {
        return cancelado;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getTituloDelEvento() {
        return tituloDelEvento;
    }

    public String getDescripcionDelEvento() {
        return descripcionDelEvento;
    }

    public double getMontoDePago() {
        return montoDePago;
    }

    public void setTituloDelEvento(String tituloDelEvento) {
        this.tituloDelEvento = tituloDelEvento;
    }

    public void setDescripcionDelEvento(String descripcionDelEvento) {
        this.descripcionDelEvento = descripcionDelEvento;
    }

    public void setMontoDePago(double montoDePago) {
        this.montoDePago = montoDePago;
    }

//RECURSIVIDAD

    public int posVacia2(int posicion){
        if (posicion<eventos.length && eventos[posicion] == null) {
            return  posicion;
        }
        else if(posicion<eventos.length){
            return  posVacia2(posicion+1);
        }
        return -1;
    }
    public static int buscarCodigoRec(int posicion, int codigo) {
            if (posicion<eventos.length && eventos[posicion] != null) {
                if (eventos[posicion].getCodigo() == codigo)
                    return posicion;
            }else if(posicion<eventos.length){
                return  buscarCodigoRec(posicion+1, codigo);
            }

        return -1;
    }
    public static int buscarCodigo2(int codigo) {
        for (int x = 0; x < eventos.length; x++) {
            if (eventos[x] != null) {
                //System.out.println(usuarios[x].getUserName() + " vs " + username);
                if (eventos[x].getCodigo() == codigo)
                    return x;
            }
        }
        return -1;
    }
    public boolean restriccionEliminarEvento(int codigo){
        int posicion = buscarCodigo2(codigo);
      // int posicion=buscarCodigo2(codigo);
        if(posicion!=-1) {
            if (eventos[posicion].typeUser.equals(LoginJAVA_TICKET.username)) {
                return true;
            } else {
                return false;
            }
        }
        return false;

    }
    /*public static int posVacia() {
        for (int i = 0; i < eventos.length; i++) {
            if (eventos[i] == null) {
                return i;
            }
        }
        return -1;
    }*/


    public static EventosJT buscarCodigo(int codigo) {
        for (EventosJT evento : eventos) {
            if (evento != null && evento.getCodigo() == codigo) {
                return evento;
            }
        }
        return null;
    }


    public static void editarEvento(int codigo) {
        int existe = buscarCodigoRec(0,codigo);

        if (existe != -1) {
            eventos[existe].opcionesEditar();

        } else {
            System.out.println("No existe el codigo");
        }


    }

    public static final void verEvento(int codigo) {
        int existe = buscarCodigoRec(0,codigo);

        if (existe != -1) {
            eventos[existe].print();
            eventos[existe].printPersonas(codigo);

        } else {
            System.out.println("No existe el codigo");
        }


    }

    public static void eliminarEvento(int codigo) {
        int existe = buscarCodigo2(codigo);
        boolean siNoB = true;

        if (existe != -1) {

            do {
                System.out.println("¿Esta seguro de eliminar el evento?");
                String siNo = lea.next();

                switch (siNo) {
                    case "si":

                        Date today = new Date();
                        Date endDate = eventos[existe].fecha;

                        if( endDate.before(today) ){
                            System.out.println("No se eliminara porque ya paso");
                            return;
                        }

                        eventos[existe].cancelado = true;

                        EventosJT miEvento = eventos[existe];

                        long diff = endDate.getTime() - today.getTime();
                        long days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

                        if( days < 1){
                            System.out.println("Se cobrara 50 porciento por estar a un dia de realizarse");
                            miEvento.multa = miEvento.totalPagar * 0.5;
                            miEvento.totalPagar = miEvento.multa;
                           // miEvento.setTotalPagar(miEvento.multa);
                        }


                        siNoB = false;
                        break;
                    case "no":
                        siNoB = false;
                        break;
                    default:
                        siNoB = false;
                        break;
                }
            } while (siNoB);
        } else {
            System.out.println("No existe el codigo");
        }
    }

    public void printPersonas(int codigo) {

    }

    public void print() {
        System.out.println("Codigo: " + getCodigo() + "\nTitulo del evento: " + getTituloDelEvento() + "\nDescripcion: "
                + getDescripcionDelEvento() + "\nMonto de Pago: " + getMontoDePago() + "\nCancelado: " + isCancelado()+"\nFecha: "+fecha.toString());
    }

    public static void listarEventos(int tipo) { // 0 = Realizados   1=Futuros   2=Cancelados
        System.out.println("Eventos");
        int cont = 0;
        for (EventosJT x : eventos) {
            if (x != null) {
                System.out.println("\n");
                switch (tipo) {
                    case 0: //Realizados
                        Date today = new Date();
                        if( x.fecha.before(today) && x.cancelado != true  )
                            x.print();
                        break;
                    case 1: // Futuros
                        Date today2 = new Date();
                        if( x.fecha.after(today2) && x.cancelado != true )
                            x.print();
                        totalGanancia();
                        break;
                    case 2: //Cancelados
                        if (x.cancelado)
                            x.print();
                        totalMulta();
                        break;
                }
            }
            cont++;
        }
         listarTiposEventos();

    }


    public static void listarTiposEventos() { // 0 = Deportivos   1=Musicales   2=Religiosos
        System.out.println("Eventos");
        int contDep = 0;
        int contMus = 0;
        int contRel= 0;


        for (EventosJT x : eventos) {
            if (x != null) {
                System.out.println("--------------------------");
                switch ( x.tipo) {
                    case 0: //Deportivo
                        contDep++;
                        break;
                    case 1: //Musicales
                      contMus++;
                        break;
                    case 2: //Religiosos
                       contRel++;
                        break;
                }
            }

        }
        System.out.println("Deportivos: "+contDep);
        System.out.println("Musicales: "+contMus);
        System.out.println("Religiosos: "+contRel);

    }
    public static void totalGanancia(){
        int totalGanancia=0;

        for(int x=0; x<eventos.length;x++){

            if(eventos[x]!=null) {
                Date today = new Date();
                Date endDate = eventos[x].fecha;
                if (endDate.after(today)) {

                    totalGanancia += eventos[x].getTotalPagar();
                    System.out.println("En posicion " + x + "es =" + totalGanancia);


                }
            }
        }
        System.out.println("Ganancia Total: " +totalGanancia);

    }
    public static void totalMulta(){
        int totalMulta=0;

        for(int x=0; x<eventos.length;x++){

            if(eventos[x]!=null) {
                    totalMulta += eventos[x].getMulta();
                    //System.out.println("En posicion " + x + "es =" + totalMulta);



            }
        }
        System.out.println("Multa total: " +totalMulta);
    }


    public abstract void opcionesEditar();

    public abstract EventosJT agregarEvento(int codigo);

    public abstract void CantidadMaximaPersonas();


}


