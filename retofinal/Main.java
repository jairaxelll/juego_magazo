
package retofinal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    
public static BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
Scanner sc = new Scanner(System.in);

Jugador Jugador = new Jugador(20,20,"no", 2);
Magazo Magazo = new Magazo(2,20,0);


private void crearcasas(int casas){
Jugador.setcasas(casas + 5);
}

private void capturarhadas(int mnumhadas, int jnumhadas){
int numerohadasmagazo = Magazo.getmnumhadas();
int numerohadasjugador = Jugador.getjnumhadas();
Magazo.setmnumhadas(numerohadasmagazo + 10);
Jugador.setjnumhadas(numerohadasjugador - 10);
numerohadasmagazo = Magazo.getmnumhadas();
numerohadasjugador = Jugador.getjnumhadas();
System.out.println("El magazo acaba de robarle 10 hadas al jugador!");
System.out.println("Ahora el magazo tiene "+ numerohadasmagazo + " hadas en total" );
System.out.println("Ahora el jugador tiene " + numerohadasjugador + " hadas en total");
}

private void liberarhadas(int mnumhadas, int jnumhadas){
int numerohadasmagazo = Magazo.getmnumhadas();
int numerohadasjugador = Jugador.getjnumhadas();
Magazo.setmnumhadas(numerohadasmagazo - 10);
Jugador.setjnumhadas(numerohadasjugador + 10);
numerohadasmagazo = Magazo.getmnumhadas();
numerohadasjugador = Jugador.getjnumhadas();
System.out.println("El jugador acaba de liberar 10 hadas del magazo!");
System.out.println("Ahora el magazo tiene "+ numerohadasmagazo + " hadas en total" );
System.out.println("Ahora el jugador tiene " + numerohadasjugador + " hadas en total");
}

private void activarescudo(String escudo){
if("si".equals(escudo)){
System.out.println("Ya tenías escudo, pierdes turno por distraido!");
}
else{
Jugador.setescudo("si");
System.out.println("Escudo activado!");
}
}

private void ograzo(String escudo){
if ("si".equals(escudo)){
Jugador.setescudo("no");
System.out.println("El escudo del jugador se ha roto!");
}
else{
int numerojpoder = Jugador.getjpoder();
Jugador.setjpoder(numerojpoder - 1);
int bonks = Magazo.getcontadordebonks();
Magazo.setcontadordebonks(bonks + 1);
}
}

private void menu(){
    System.out.println(("""
    ¡Bienvenido a jugador y magazo!
    1.Jugar una partida
    2.Leer como jugar el juego
    3.Salir del juego
    """));        
}

private void turnojugador(){
      System.out.println("Es el turno del jugador, que accion deseas hacer?");
      System.out.println("Actualmente cuentas con " + Jugador.getcasas() + " casas, " + Jugador.getjnumhadas() + " hadas, " + Jugador.getjpoder()+ " puntos de poder y "+ Jugador.getescudo() + " tienes escudo!");
      System.out.println("""                       
          que acción deseas hacer?
          1.-Construir 5 casas para 5 hadas.
          2.-Rescatar 10 hadas(+10 hadas al jugador, -10 hadas al magazo).
          3.-Activar escudo de protección (protege un golpe del ogro)
                        """);
      int jaccion;
         jaccion = sc.nextInt();
         switch(jaccion){             
             case 1:
              crearcasas(Jugador.getcasas());
              break;
             case 2:
              if(Jugador.getjnumhadas() + 10 > Jugador.getcasas()){
               System.out.println("Rescate fallido! No tienes suficientes casas!");
              } 
              else{
              liberarhadas(Jugador.getjnumhadas(), Magazo.getmnumhadas());
              }
              break;
             case 3:
             activarescudo(Jugador.getescudo());
             break;
         }                    
}

private void turnomagazo(){
    System.out.println("Es el turno del magazo, que accion deseas hacer?");
    System.out.println("Actualmente cuentas con " + Magazo.getmnumhadas() + " hadas y " + Magazo.getmpoder() + " de puntos de poder");
    System.out.println("""
          ¿Que acción deseas hacer?
          1.-Raptar 10 hadas (+10 hadas para el mago, -10 para el jugador)
          2.- Golpear al jugador con el ogro por uno de daño. (si el jugador no tiene escudo)
                        """);    
          int maccion;
         maccion = sc.nextInt();
         switch(maccion){             
             case 1:
              capturarhadas(Magazo.getmnumhadas(), Jugador.getjnumhadas());
              break;
             case 2:
             ograzo(Jugador.getescudo());
              break;
         }   
}

private void actualizarpoder(int mnumhadas,int jnumhadas,int contadordebonks){

    int bonks = Magazo.getcontadordebonks();
    int numerohadasmago = Magazo.getmnumhadas();
    int numerohadasjugador = Jugador.getjnumhadas();
    Jugador.setjpoder(numerohadasjugador/10 - bonks);
    Magazo.setmpoder(numerohadasmago/10);
    
}

private void instrucciones(){
        System.out.println("""
    Las reglas son las siguientes:            
    Este es un juego de turno de dos jugadores, el jugador y el magazo.
    El jugador puede hacer dos acciones por turno, mientras que el magazo puede hacer una.
    El jugador principal tiene un nivel de poder que aumenta cada que rescata 10 hadas.
    El jugador tendrá que construir casas para las hadas y llevarlas a vivir ahí.                           
    El mago obtiene su poder dependiendo de la cantidad de hadas que haya raptado
    Cada 10 hadas equivale a una unidad de poder    
    El juego termina cuando el mago o el jugador hayan perdido por completo su poder.                              
                           
    El mago puede elegir entre:
    -Raptar 10 hadas (+10 hadas para el mago, -10 para el jugador)
    -Golpear al jugador con el ogro por uno de daño.
                          
    El jugador puede elegir entre:
        -Construir 5 casas para 5 hadas.
        -Rescatar 10 hadas(+10 hadas al jugador, -10 hadas al magazo).
        -Activar escudo de protección (protege un golpe del ogro)
    """);    
}
        
public static void main(String[] args){
    

    Scanner sc = new Scanner(System.in);
    int option; 
    String juego = "si";
    Main main = new Main();
    do{
    main.menu();
    option = sc.nextInt();  
    switch(option){
    
        case 1:
        System.out.println("El juego va a comenzar!");
        do{
         main.turnojugador();      
         main.actualizarpoder(main.Jugador.getjnumhadas(), main.Magazo.getmnumhadas(), main.Magazo.getcontadordebonks());
         if(main.Jugador.getjpoder() == 0){
         System.out.println("El jugador se ha quedado sin poder, el magazo gana! ");
         juego = "no";
         option = 3;
         break;
         }
         if(main.Magazo.getmpoder()== 0){
         System.out.println("El magazo se ha quedado sin poder, el jugador gana! ");
         juego = "no";
         option = 3;         
         break;
         }  
         
         
         main.turnojugador();      
         main.actualizarpoder(main.Jugador.getjnumhadas(), main.Magazo.getmnumhadas(), main.Magazo.getcontadordebonks());
         if(main.Jugador.getjpoder() == 0){
         System.out.println("El jugador se ha quedado sin poder, el magazo gana! ");
         juego = "no";
         option = 3;         
         break;         
         }
         if(main.Magazo.getmpoder()== 0){
         System.out.println("El magazo se ha quedado sin poder, el jugador gana! ");
         juego = "no";
         option = 3;         
         break;
         }  
         
         main.turnomagazo();
         main.actualizarpoder(main.Jugador.getjnumhadas(), main.Magazo.getmnumhadas(), main.Magazo.getcontadordebonks());
         if(main.Jugador.getjpoder() == 0){
         System.out.println("El jugador se ha quedado sin poder, el magazo gana! ");
         juego = "no";
         option = 3;
         break;
         }
         if(main.Magazo.getmpoder()== 0){
         System.out.println("El magazo se ha quedado sin poder, el jugador gana! ");
         juego = "no";
         option = 3;
         break;
         }          
        }while("si".equals(juego));           
        break;
                 
        case 2:
        main.instrucciones();
        break;   
        
        case 3:
        break;         
    }
        
    }while(option != 3);
}
}

        

        
        
 

        
            
            

    
    

