import java.util.Scanner;

public final class PrincipalJT{
    public static Scanner lea= new Scanner(System.in);


     void  MenuPrincipal(){
        boolean regresar=false;
        boolean error=false;
        AdministradoresJT userA= new AdministradoresJT();
        LoginJAVA_TICKET login=new LoginJAVA_TICKET();
        EventosJT evD=new DeportivoJT();
        EventosJT evM=new MusicalesJT();
        EventosJT evR=new ReligiososJT();
        lea.useDelimiter("\n");



         do {
            System.out.println("------------------------------------------");
            System.out.println("MENU PRINCIPAL\n1.Administrador de eventos.\n2.Administrador de Usuarios\n3.Reportes\n4.Salir");
            System.out.println("------------------------------------------");
            System.out.println("Ingrese el numero de opcion");
            int opcion=lea.nextInt();

            switch(opcion){
                case 1:
                    do{
                        System.out.println("------------------------------------------");
                        System.out.println("\n1.Crear Evento.\n2.Eliminar Evento\n3.Editar Evento\n4.Ver Evento \n5. Regresar al Menu Principal");
                        System.out.println("------------------------------------------");
                        System.out.println("Ingrese el numero de opcion");
                        int opcionEventos=lea.nextInt();


                        switch(opcionEventos) {
                            case 1:
                                    if(userA.restricciones(LoginJAVA_TICKET.username)){

                                    System.out.println("------------------------------------------");
                                    System.out.println("\n1.Deportivo .\n2.Musical\n3.Religioso\n");
                                    System.out.println("------------------------------------------");
                                    System.out.println("Ingrese el numero de opcion");
                                    int elegirEvento = lea.nextInt();

                                    switch (elegirEvento) {
                                        case 1:

                                            System.out.println("Ingrese el codigo del evento: ");
                                            int codigoD = lea.nextInt();
                                            evD.agregarEvento(codigoD);
                                            break;
                                        case 2:
                                            System.out.println("Ingrese el codigo del evento: ");
                                            int codigoM = lea.nextInt();
                                            evM.agregarEvento(codigoM);

                                            break;
                                        case 3:
                                            System.out.println("Ingrese el codigo del evento: ");
                                            int codigoR = lea.nextInt();
                                           evR.agregarEvento(codigoR);
                                            break;
                                    }

                                    error = true;
                                }else{
                                    System.out.println("El usuario Limitado no puede ingresar a esta opcion");
                                    error=true;
                                }
                                //userA.verUsuario(LoginJAVA_TICKET.username );
                                break;
                            case 2:
                                    System.out.println("Ingrese el codigo del evento: ");
                                    int codigo1 = lea.nextInt();
                                    if(evD.restriccionEliminarEvento(codigo1) || evR.restriccionEliminarEvento(codigo1) || evM.restriccionEliminarEvento(codigo1)) {
                                        EventosJT.eliminarEvento(codigo1);
                                        //System.out.println("Eliminando evento ");
                                    }else{
                                        System.out.println("No puedes eliminar el evento, porque no lo creaste, o no existe el codigo");
                                        //System.out.println( evD.restriccionEliminarEvento(codigo1));
                                    }
                                   // EventosJT e = EventosJT.buscarCodigo(codigo1);
                                   // if(e != null)
                                   //     e.print();

                                   // EventosJT.listarEventos();
                                error=true;
                                break;
                            case 3:
                                if(userA.restricciones(LoginJAVA_TICKET.username)) {

                                        System.out.println("Ingrese el codigo del evento: ");
                                        int codigo = lea.nextInt();
                                        EventosJT.editarEvento(codigo);

                                }else{
                                    System.out.println("El usuario Limitado no puede ingresar a esta opcion");
                                }
                                error=true;
                                break;
                            case 4:
                                    System.out.println("Ingrese el codigo del evento: ");
                                    int verEvento = lea.nextInt();
                                    EventosJT.verEvento(verEvento);
                                error=true;
                                break;
                            case 5:
                                error=false;
                                regresar = true;
                                break;
                            default:
                                System.out.println("------------------------------------------");
                                System.out.println("Ingrese solamente el numero de una de las opciones: ");
                                error = true;
                                break;
                        }



                    }while(error);

                    break;
                case 2:
                    if(userA.restricciones2(LoginJAVA_TICKET.username)) {

                        do {
                            System.out.println("------------------------------------------");
                            System.out.println("\n1.Crear Usuario.\n2.Eliminar Usuario\n3.Editar Usuario\n4.Regresar aL Menu Principal");
                            System.out.println("------------------------------------------");
                            System.out.println("Ingrese el numero de opcion");
                            int opcionEventos = lea.nextInt();


                            switch (opcionEventos) {
                                case 1:
                                    System.out.println("Ingrese el username: ");
                                    String username = lea.next();
                                    userA.agregarUsuario(username);

                                    System.out.println("Ingresado correctamente");
                                    error = true;
                                    break;
                                case 2:
                                    System.out.println("Ingrese el username: ");
                                    String username2 = lea.next();
                                    userA.eliminarUsuario(username2);
                                    error = true;
                                    break;
                                case 3:
                                    System.out.println("Ingrese el username: ");
                                    String userN = lea.next();
                                    userA.editarUser(userN);
                                    error = true;
                                    break;
                                case 4:
                                    error = false;
                                    regresar = true;
                                    break;
                                default:
                                    System.out.println("------------------------------------------");
                                    System.out.println("Ingrese solamente el numero de una de las opciones: ");
                                    error = true;
                                    break;
                            }


                        } while (error);
                    }else{
                        System.out.println("Solamente el usuario Administrador puede ingresar a esta opcion");
                    }
                    break;
                case 3:
                    do{
                        System.out.println("------------------------------------------");
                        System.out.println("\n1.Eventos Realizados.\n2.Eventos Futuros\n3.Eventos Cancelados\n4.Ver Perfil de Usuarios \n5. Regresar al Menu Principal");
                        System.out.println("------------------------------------------");
                        System.out.println("Ingrese el numero de opcion");
                        int opcionEventos=lea.nextInt();


                        switch(opcionEventos) {   // 0 = Realizados   1=Futuros   2=Cancelados
                            case 1:

                                System.out.println("Eventos");
                                int cont = 0;
                                EventosJT.listarEventos(0);
                                error=true;

                                break;
                            case 2:
                                EventosJT.listarEventos(1);
                                //evD.totalGanancia();
                                error=true;
                                break;
                            case 3:
                                EventosJT.listarEventos(2);
                                error=true;

                                break;
                            case 4:
                                userA.verUsuario(LoginJAVA_TICKET.username);
                                error=true;
                                break;
                            case 5:
                                error=false;
                                regresar = true;
                                break;
                            default:
                                System.out.println("------------------------------------------");
                                System.out.println("Ingrese solamente el numero de una de las opciones: ");
                                error = true;
                                break;
                        }


                    }while(error);
                    regresar = true;
                    break;
                case 4:
                    regresar=false;
                    break;
                default:
                    System.out.println("------------------------------------------");
                    System.out.println("Ingrese solamente el numero de una de las opciones: ");
                    regresar=true;
                    break;


            }


        }while(regresar);
    }


}
