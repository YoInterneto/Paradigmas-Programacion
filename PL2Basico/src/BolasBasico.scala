
import java.io._
import java.text.SimpleDateFormat
import java.util.Calendar

object Bolas {
  
  
  //**********************************************************************************************
  //Funcion que inicia el juego con tablero vacio
  //**********************************************************************************************
  def iniciar_juego(){
    val tablero_vacio = List(List('_','_','_','_','_','_','_','_','_'),
                             List('_','_','_','_','_','_','_','_','_'),
                             List('_','_','_','_','_','_','_','_','_'),
                             List('_','_','_','_','_','_','_','_','_'),
                             List('_','_','_','_','_','_','_','_','_'),
                             List('_','_','_','_','_','_','_','_','_'),
                             List('_','_','_','_','_','_','_','_','_'),
                             List('_','_','_','_','_','_','_','_','_'),
                             List('_','_','_','_','_','_','_','_','_'))
                        
    val tablero_inicial = llenar_tablero_inicial(tablero_vacio,0)
    mostrar_tablero(tablero_inicial)
    escoger_bola(tablero_inicial,0)                      
  }
  
  
  //**********************************************************************************************
  //Funcion que llena 9 posiciones aleatorias del tablero con colores tambien aleatorios
  //**********************************************************************************************                   
  def llenar_tablero_inicial(tablero: List[List[Char]], cont: Int):List[List[Char]]={
    
    //Posibles colores
    val lista = List('A','N','R','V','M','G')
    
    val r = scala.util.Random
    val posicion1 = r.nextInt(9)
    val posicion2 = r.nextInt(9)
    val color = r.nextInt(6)
    val valor = lista(color)
    
    //Ya se han llenado los 9
    if (cont==9){
      return tablero
    }
    //Si no se han llenado los 9
    else{
      //Si esa posicion no se ha reemplazado
      if (tablero(posicion1)(posicion2) == '_'){
        val tablero_inicial = reemplazar(tablero(posicion1), posicion2, valor) 
        val tablero_inicial_final = reemplazar_lista(tablero, posicion1, tablero_inicial)
        llenar_tablero_inicial(tablero_inicial_final,cont+1)
        
      }
      //Si la posicion esta reemplazada volvemos otra vez
      else { llenar_tablero_inicial(tablero,cont) }
   } 
  }
  
  
  //**********************************************************************************************
  //Funcion que comprueba que las coordenadas introducidas sea correctas
  //**********************************************************************************************
  def comprobar_limite(x: Int, y: Int):Boolean={
    
    if(x<=8 && x>=0 && y>=0 && y<=8){
      true
    }
    else{
      println("\nERROR: Posicion incorrecta. Intente otra posicion\n")
      false
    }
  }
  
  
  //********************************
  //Funcion que pide al usuario que elija una ficha del tablero para moverla posteriormente,
  //comprobando la posicion y si la partida ha finalizado o no
  //********************************
  def escoger_bola(tablero: List[List[Char]],puntuacion:Int){
     
    //Si la partida ha finalizado se muestra la puntuacion y se llama a la funcion
     if(final_partida(tablero, 0, 0)){
       println("\nPARTIDA FINALIZADA.")
       println("PUNTUACION: "+ puntuacion +"pts\n")
       terminar_juego(puntuacion, false)
     }
     //Si no ha finalizado pedimos y comprobamos la posicion
     else{
       try{
         print("Introduzca la fila de la bola que quiere utilizar(1-9): ")
         val xIn = scala.io.StdIn.readInt()
         print("Introduzca la columna de la bola que quiere utilizar(1-9): ")
         val yIn = scala.io.StdIn.readInt()
         val x = xIn - 1
         val y = yIn - 1
       
         if(comprobar_limite(x,y)){
         
           val bola = tablero(x)(y)
         
         //Si en el hueco hay una bola
         if(bola != '_'){
           println("\nBOLA ESCOGIDA ["+ bola +"]\n")
           mover_bola(tablero,bola,x,y,puntuacion)
         }
         else{
           println("\nERROR: Posicion vacia. Intente otra posicion.\n")
           escoger_bola(tablero,puntuacion)
         }
       }
       else{
         escoger_bola(tablero,puntuacion)
       }
       }
       //Si no se introduce un numero, salta la excepcion, y se vuelve a introducir
       catch{
         case e: NumberFormatException => println("\nERROR: Formato numerico incorrecto, empiece otra vez\n")
         escoger_bola(tablero,puntuacion)
         
       }
     }  
  }
  
  
  //********************************
  //Funcion que mueve una bola de una posicion a otra y sigue con la ejecucion del juego llamando
  //a mas funciones
  //********************************
  def mover_bola(tablero: List[List[Char]], bola: Char, x: Int, y: Int, puntuacion: Int){
    
    try{
      print("Introduzca la fila donde la quiere introducir(1-9): ")
      val xIn = scala.io.StdIn.readInt()
      print("Introduzca la columna donde la quiere introducir(1-9): ")
      val yIn = scala.io.StdIn.readInt()
      
      val x2 = xIn - 1
      val y2 = yIn - 1
      
      //Comprobamos que el numero introducido no se pase de los limites
      if(comprobar_limite(x2, y2)){
        
        val hueco = tablero(x2)(y2)
        
        //Si el hueco donde queremos introducir esta vacio
        if(hueco == '_'){
          val fila_nueva = reemplazar(tablero(x2),y2,bola)
          val tablero_sin_hueco = reemplazar_lista(tablero, x2, fila_nueva) 
          //Donde estaba la bola antes, ahora esta vacio
          val tablero_hueco = reemplazar(tablero_sin_hueco(x), y, '_') 
          //Lo reemplazamos
          val tablero_con_hueco = reemplazar_lista(tablero_sin_hueco, x, tablero_hueco)
          //Rellenamos el tablero con las 3 nuevas posiciones
          val tablero_sig_turno = rellenar_turno(tablero_con_hueco, 0)
          
          //Nueva puntuacion
          val puntuacionAux = calcular_puntuacion(tablero_sig_turno, 0, 0, 0) * 75
          val puntuacion_acumulada = puntuacion + puntuacionAux
          println("\nPuntuacion acumulada: "+ puntuacion_acumulada +"\n")
          
          //Comprobamos si se pueden eliminar fichas que han formado figuras
          val tablero_comprobado = comprobar_tablero(tablero_sig_turno)
          mostrar_tablero(tablero_comprobado)
          
          //Volvemos a llamar a la funcion para seguir con el juego
          escoger_bola(tablero_comprobado,puntuacion_acumulada)
           
        }
        //Si hay una ficha ya en la posicion elegida, la volvemos a pedir
        else{
          println("\nERROR: Posicion ocupada. Intente otra posicion.\n")
          mover_bola(tablero,bola,x,y,puntuacion)
        }
      }
      //Si los limites estan mal volvemos a pedirlos
      else{
        mover_bola(tablero,bola,x,y,puntuacion)
      }   
    }
    //Si no se introduce un numero, salta la excepcion, y se vuelve a introducir
    catch{
      case e: NumberFormatException => println("\nERROR: Formato numerico incorrecto, empiece otra vez\n")
      mover_bola(tablero,bola,x,y,puntuacion)
         
       }
  }
  
  
  //**********************************************************************************************
  //Funcion que muestra un menu con las opciones de las que dispone el usuario una vez acabada la
  //partida, guardar puntuacion, nueva partida o terminar juego
  //**********************************************************************************************
  def terminar_juego(puntuacion: Int, guardado: Boolean){
    
    if(guardado){
      println(" 1)Nueva partida.")
      println(" 2)Terminar juego.")
      print("Introduzca la opcion que desee: ")
    }
    else{
      println(" 1)Guardar puntuacion.")
      println(" 2)Nueva partida.")
      println(" 3)Terminar juego.")
      print("Introduzca la opcion que desee: ")
    }
    
    val respuesta = scala.io.StdIn.readInt()
    
    if(respuesta == 1 && !guardado){  
      println("\nOPCION 1 -> Guardar puntuacion")
      println("Introduzca su nombre: ")
      val nombre = scala.io.StdIn.readLine()
      
      var reloj = Calendar.getInstance()
      var min = reloj.get(Calendar.MINUTE)
      var h = reloj.get(Calendar.HOUR_OF_DAY)
      val hora = h +":"+ min
      
      val format = new SimpleDateFormat("d/M/y")
      val fecha = format.format(Calendar.getInstance().getTime())
      
      val texto = "***************************\n"+
                  "   ["+ fecha + " " + hora +"]\n"+
                  "Jugador: "+ nombre + "\n"+
                  "Puntuacion: "+ puntuacion + "\n"+
                  "***************************\n\n"
      val pw = new PrintWriter(new BufferedWriter(new FileWriter("./src/puntuaciones.txt", true)))
      try pw.write(texto) finally pw.close()
      
      terminar_juego(puntuacion, true)
    }
    else if((respuesta == 2 && !guardado) || (respuesta == 1 && guardado)){
      if(guardado){println("\nOPCION 1 -> Nueva partida")}
      else{println("\nOPCION 2 -> Nueva partida")}
      iniciar_juego()
    }
    else if((respuesta == 3 && !guardado) || (respuesta == 2 && guardado)){
      if(guardado){println("\nOPCION 2 -> Terminar juego\nGracias por jugar.")}
      else{println("\nOPCION 3 -> Terminar juego\nGracias por jugar.")}
      System.exit(1)
    }
    else{
      println("\nERROR: numero incorrecto, intentelo de nuevo\n")
      if(guardado){terminar_juego(puntuacion, true)}
      else{terminar_juego(puntuacion, false)}
      
    }
  }
  
  
  //**********************************************************************************************
  //Funcion que recorre el tablero antes de que este sea comprobado para ver las fichas que forman
  //una figura de 5 o mas posiciones contiguas y suma su puntuacion a la puntuacion de la partida
  //**********************************************************************************************
  def calcular_puntuacion(tablero: List[List[Char]], puntuacion: Int, fila: Int, columna: Int):Int ={
    if(fila == 9){
      puntuacion
    }
    else{
      if(columna == 9){
        calcular_puntuacion(tablero, puntuacion, fila+1, 0)
      }
      else{
        if(tablero(fila)(columna) != '_'){
          val horizontal_cont = horizontal(tablero, 1, fila, columna)
          val vertical_cont = vertical(tablero, 1, fila, columna)
          val diagonal1Izq_cont = diagonal1Izq(tablero, 1, fila, columna)
          val diagonal1Dcha_cont = diagonal1Dcha(tablero, 1, fila, columna)
          val diagonal2Izq_cont = diagonal2Izq(tablero, 1, fila, columna)
          val diagonal2Dcha_cont = diagonal2Dcha(tablero, 1, fila, columna)
          
          if((horizontal_cont < 5) && (vertical_cont < 5) && 
          (diagonal1Izq_cont < 5) && (diagonal1Dcha_cont < 5) &&
          (diagonal2Izq_cont < 5) && (diagonal2Dcha_cont < 5)){
            
            calcular_puntuacion(tablero, puntuacion, fila, columna+1)
            
          }else{
            //Borramos las fichas horizontales
            if(horizontal_cont >= 5){
              val tableroAux = borrar_horizontal(tablero, horizontal_cont, fila, columna)
              
              calcular_puntuacion(tableroAux, puntuacion + horizontal_cont, fila, columna+1)
            //Borramos las fichas verticales
            }else if(vertical_cont >= 5){
              val tableroAux = borrar_vertical(tablero, vertical_cont, fila, columna) //Tablero borrando fila + vertical_cont posiciones
              
              calcular_puntuacion(tableroAux, puntuacion + vertical_cont, fila, columna+1)
            //Borramos las fichas diagonal izquierda, con las fichas abajo
            }else if(diagonal1Izq_cont >= 5){
              val diagonalSecundaria: Int = diagonal1Izq_cont / 2
              val diagonalPrincipal = diagonal1Izq_cont - diagonalSecundaria
              
              val tableroAux = borrar_izquierda(tablero, diagonalPrincipal, fila, columna)
              val tableroAux1 = borrar_izquierda(tableroAux, diagonalSecundaria, fila+1, columna)
              
              calcular_puntuacion(tableroAux1, puntuacion + diagonal1Izq_cont, fila, columna+1)
            //Borramos las fichas diagonal derecha, con las fichas abajo  
            }else if(diagonal1Dcha_cont >= 5){
              val diagonalSecundaria: Int = diagonal1Dcha_cont / 2
              val diagonalPrincipal = diagonal1Dcha_cont - diagonalSecundaria
              
              val tableroAux = borrar_derecha(tablero, diagonalPrincipal, fila, columna)
              val tableroAux1 = borrar_derecha(tableroAux, diagonalSecundaria, fila+1, columna)
              
              calcular_puntuacion(tableroAux1, puntuacion + diagonal1Dcha_cont, fila, columna+1)
            //Borramos las fichas diagonal izquierda, con las fichas arriba  
            }else if(diagonal2Izq_cont >= 5){
              val diagonalSecundaria: Int = diagonal2Izq_cont / 2
              val diagonalPrincipal = diagonal2Izq_cont - diagonalSecundaria
              
              val tableroAux = borrar_izquierda(tablero, diagonalPrincipal, fila, columna)
              val tableroAux1 = borrar_izquierda(tableroAux, diagonalSecundaria, fila, columna-1)
              
              calcular_puntuacion(tableroAux1, puntuacion + diagonal2Izq_cont, fila, columna+1)
            //Borramos las fichas diagonal derecha, con las fichas arriba  
            }else{
              val diagonalSecundaria: Int = diagonal2Dcha_cont / 2
              val diagonalPrincipal = diagonal2Dcha_cont - diagonalSecundaria
              
              val tableroAux = borrar_derecha(tablero, diagonalPrincipal, fila, columna)
              val tableroAux1 = borrar_derecha(tableroAux, diagonalSecundaria, fila, columna+1)
              
              calcular_puntuacion(tableroAux1, puntuacion + diagonal2Dcha_cont, fila, columna+1)
            }
          }
        }
        else{
          calcular_puntuacion(tablero, puntuacion, fila, columna+1)
        }
      }
    }
  }
  
  
  //**********************************************************************************************
  //Funcion que añade 3 bolas de colores random en posiciones aleatorias del tablero, las cuales
  //esten vacias
  //**********************************************************************************************
  def rellenar_turno(tablero:List[List[Char]],contador:Int):List[List[Char]]={

    val huecos = huecos_restantes(tablero, 0, 0, 0)
    val lista = List('A','N','R','V','M','G')
    val r = scala.util.Random
    val color = r.nextInt(6)
    val posicion1 = r.nextInt(9)
    val posicion2 = r.nextInt(9)
    val valor = lista(color)
    
    if(contador==3){
      tablero
    }
    else{
      //Si queda un hueco lo rellena y devuelve el tablero
      if(huecos==1){
        //Si la posicion es vacio lo mete
        if(tablero(posicion1)(posicion2)=='_'){
          
          val tablero_inicial = reemplazar(tablero(posicion1), posicion2, valor)
          val tablero_inicial_final = reemplazar_lista(tablero, posicion1, tablero_inicial)
          tablero_inicial_final
        }
        //Si no llama de nuevo a la funcion
        else {
          rellenar_turno(tablero,contador)
        }
      }
      else{
        //Si queda mas de un huevo rellena la posicion pero no devuelve aun el tablero
        if(tablero(posicion1)(posicion2)=='_'){
          val tablero_inicial = reemplazar(tablero(posicion1), posicion2, valor)
          val tablero_inicial_final = reemplazar_lista(tablero, posicion1, tablero_inicial)
          rellenar_turno(tablero_inicial_final,contador+1)
        }
        else {
          rellenar_turno(tablero,contador)
        }
      }   
    }
  }
  
  
  //**********************************************************************************************
  //Comprueba la condicion de si es final de la partida o no y retorna un boolean true(acabada)
  //o false(no terminada)
  //**********************************************************************************************
  def final_partida(tablero: List[List[Char]], fila: Int, columna: Int):Boolean={
    if(fila==9){
       true
    }
    else{
      if(columna==9){
        final_partida(tablero,fila+1,0)
      }
      else{
        if(tablero(fila)(columna)=='_'){
          false
      }
        else{
          final_partida(tablero,fila,columna+1)
        }
      }
    }
  }
  
  
  //**********************************************************************************************
  //Funcion que cuenta las posiciones del tablero que no estan ocupadas por ninguna ficha
  //**********************************************************************************************
  def huecos_restantes(tablero: List[List[Char]], contador: Int, fila: Int, columna: Int): Int={
    if(fila==9){
      contador
    }
    else{
      if(columna==9){
      huecos_restantes(tablero, contador, fila+1, 0)
    }
    else{
      if(tablero(fila)(columna)=='_'){
        huecos_restantes(tablero, contador+1, fila,columna+1)
      }
      else{
        huecos_restantes(tablero, contador, fila,columna+1)
      }
    }
   }
  }
  
  
  //**********************************************************************************************
  //Funciones que muestran el tablero de una forma lo mas clara posible
  //**********************************************************************************************
  def mostrar_tablero(tablero: List[List[Char]]){
    print("    ")
    mostrar_numeros(tablero(0), 0)
    mostrar_tableroAux(tablero, 0)
  }
  def mostrar_numeros(fila: List[Char], contador: Int){
    if(contador == fila.length){
      println(" ")
    }
    else{
      print((contador+1) + "   ")
      mostrar_numeros(fila, contador+1)
    }
  }
  def mostrar_tableroAux(tablero: List[List[Char]], contador: Int){
    if(contador == tablero.length){
    }
    else{
      print((contador+1) + " ")
      mostrar_fila(tablero(contador), 0)
      println("")
      mostrar_tableroAux(tablero, contador+1)
    }
  }
  def mostrar_fila(fila: List[Char], contador: Int){
    if(contador == fila.length){
      print("|\n")
    }
    else{
      val casilla = fila(contador)
      if(casilla == '_'){
        print("|   ")
        mostrar_fila(fila, contador+1)
      }
      else{
        print("| "+ casilla +" ")
        mostrar_fila(fila, contador+1)
      }
    }
  }
  
  
  //**********************************************************************************************
  //Funciones que sustituyen el uso del update()
  //**********************************************************************************************
  def reemplazar(lista:List[Char],index:Int,valor:Char):List[Char]={
    my_update(lista, index, valor, 0, List())
  }
  def my_update(lista:List[Char],index:Int,valor:Char,cont:Int,listaOut:List[Char]):List[Char]={
    if(cont==index){
      val listaAux = listaOut:+valor
      my_update(lista, index, valor, cont+1, listaAux)
    }
    else if(cont==lista.length){
      listaOut
    }
    else{
      val listaAux = listaOut:+lista(cont)
      my_update(lista, index, valor, cont+1, listaAux)
    }
  }
  def reemplazar_lista(lista:List[List[Char]],index:Int,valor:List[Char]):List[List[Char]]={
    my_update_lista(lista, index, valor, 0, List())
    
  }
  def my_update_lista(lista:List[List[Char]],index:Int,valor:List[Char],cont:Int,listaOut:List[List[Char]]):List[List[Char]]={
    if(cont==index){
      val listaAux = listaOut:+valor
      my_update_lista(lista, index, valor, cont+1, listaAux)
    }
    else if(cont==lista.length){
      listaOut
    }
    else{
      val listaAux = listaOut:+lista(cont)
      my_update_lista(lista, index, valor, cont+1, listaAux)
    }
  }
  
  
  //**********************************************************************************************
  //Funcion que itera el tablero de juego y comprueba si hay alguna colocacion de las fichas en
  //el tablero que satisfaga las condiciones
  //**********************************************************************************************
  def comprobar_tablero(tablero:List[List[Char]]):List[List[Char]] = {
    comprobar_tableroAux(tablero, 0, 0)
  }
  def comprobar_tableroAux(tablero:List[List[Char]],fila:Int,columna:Int):List[List[Char]] = {
    //println("Puntuacion: "+puntuacion)
    //Si llegamos al final de una fila vamos a la siguiente
    if(columna == 9){
      comprobar_tableroAux(tablero, fila + 1, 0)
    }
    //Si llegamos al final retornamos el tablero
    else if(fila == 9){
      tablero
    }
    //Para las demas posiciones, comprobamos su horizontal, vertical y diagonales
    else{
      //Si la posicion no es null comprueba
      if(tablero(fila)(columna) != '_'){
        val horizontal_cont = horizontal(tablero, 1, fila, columna)
        val vertical_cont = vertical(tablero, 1, fila, columna)
        val diagonal1Izq_cont = diagonal1Izq(tablero, 1, fila, columna)
        val diagonal1Dcha_cont = diagonal1Dcha(tablero, 1, fila, columna)
        val diagonal2Izq_cont = diagonal2Izq(tablero, 1, fila, columna)
        val diagonal2Dcha_cont = diagonal2Dcha(tablero, 1, fila, columna)
        
        if((horizontal_cont < 5) && (vertical_cont < 5) && 
          (diagonal1Izq_cont < 5) && (diagonal1Dcha_cont < 5) &&
          (diagonal2Izq_cont < 5) && (diagonal2Dcha_cont < 5)){
        comprobar_tableroAux(tablero, fila, columna+1)
        
        //Si se encuentra una coincidencia se borran las fichas del tablero y se
        //sigue iterando con el mismo tablero
        }else{
          
          val ficha = tablero(fila)(columna)
          
          //Borramos las fichas horizontales
          if(horizontal_cont >= 5){
            val tableroAux = borrar_horizontal(tablero, horizontal_cont, fila, columna) //Tablero borrando columna + horizontal_cont posiciones
            println("\nCOMPLETADA: Horizontal["+ (fila+1) +","+ (columna+1) +"] Color: "+ ficha +"\n")
            
            comprobar_tableroAux(tableroAux, fila, columna+1)
          //Borramos las fichas verticales
          }else if(vertical_cont >= 5){
            val tableroAux = borrar_vertical(tablero, vertical_cont, fila, columna) //Tablero borrando fila + vertical_cont posiciones
            println("\nCOMPLETADA: Vertical["+ (fila+1) +","+ (columna+1) +"] Color: "+ ficha +"\n")
            
            comprobar_tableroAux(tableroAux, fila, columna+1)
          //Borramos las fichas diagonal izquierda, con las fichas abajo
          }else if(diagonal1Izq_cont >= 5){
            val diagonalSecundaria: Int = diagonal1Izq_cont / 2
            val diagonalPrincipal = diagonal1Izq_cont - diagonalSecundaria
            
            val tableroAux = borrar_izquierda(tablero, diagonalPrincipal, fila, columna)
            val tableroAux1 = borrar_izquierda(tableroAux, diagonalSecundaria, fila+1, columna)
            println("\nCOMPLETADA: DiagonalIzquierda["+ (fila+1) +","+ (columna+1) +"] Color: "+ ficha +"\n")
            
            comprobar_tableroAux(tableroAux1, fila, columna+1)
          //Borramos las fichas diagonal derecha, con las fichas abajo  
          }else if(diagonal1Dcha_cont >= 5){
            val diagonalSecundaria: Int = diagonal1Dcha_cont / 2
            val diagonalPrincipal = diagonal1Dcha_cont - diagonalSecundaria
            
            val tableroAux = borrar_derecha(tablero, diagonalPrincipal, fila, columna)
            val tableroAux1 = borrar_derecha(tableroAux, diagonalSecundaria, fila+1, columna)
            println("\nCOMPLETADA: DiagonalDerecha["+ (fila+1) +","+ (columna+1) +"] Color: "+ ficha +"\n")
            
            comprobar_tableroAux(tableroAux1, fila, columna+1)
          //Borramos las fichas diagonal izquierda, con las fichas arriba  
          }else if(diagonal2Izq_cont >= 5){
            val diagonalSecundaria: Int = diagonal2Izq_cont / 2
            val diagonalPrincipal = diagonal2Izq_cont - diagonalSecundaria
            
            val tableroAux = borrar_izquierda(tablero, diagonalPrincipal, fila, columna)
            val tableroAux1 = borrar_izquierda(tableroAux, diagonalSecundaria, fila, columna-1)
            println("\nCOMPLETADA: DiagonalIzquierda["+ (fila+1) +","+ (columna+1) +"] Color: "+ ficha +"\n")
            
            comprobar_tableroAux(tableroAux1, fila, columna+1)
          //Borramos las fichas diagonal derecha, con las fichas arriba  
          }else{
            val diagonalSecundaria: Int = diagonal2Dcha_cont / 2
            val diagonalPrincipal = diagonal2Dcha_cont - diagonalSecundaria
            
            val tableroAux = borrar_derecha(tablero, diagonalPrincipal, fila, columna)
            val tableroAux1 = borrar_derecha(tableroAux, diagonalSecundaria, fila, columna+1)
            println("\nCOMPLETADA: DiagonalIzquierda["+ (fila+1) +","+ (columna+1) +"] Color: "+ ficha +"\n")
            
            comprobar_tableroAux(tableroAux1, fila, columna+1)
          }
        }
      }
      //Si es null no la comprueba y sigue iterando
      else{
        comprobar_tableroAux(tablero, fila, columna+1)
      }
    }
  }
  
  
  //**********************************************************************************************
  //Cuenta cuantas fichas de un mismo color hay de forma consecutiva en una horizontal del tablero
  //**********************************************************************************************
  def horizontal(tablero: List[List[Char]], contador: Int, fila: Int, columna: Int):Int = {
    if(columna==8){
      contador
    }
    else{
      if(tablero(fila)(columna) == tablero(fila)(columna+1)){
        horizontal(tablero, contador + 1, fila, columna + 1)
      }
      else{
        contador
      }
    }
  }
  //**********************************************************************************************
  //Borra n fichas que sean consecutivas y horizontales en el tablero
  //**********************************************************************************************
  def borrar_horizontal(tablero: List[List[Char]], contador: Int, fila: Int, columna: Int):List[List[Char]] = {
    if(contador == 0){
      tablero
    }
    else{
      //borramos la siguiente posicion que sera (fila)(columna + contador) y seguimos
      val index = columna + contador - 1
      
      val lineaTablero = tablero(fila)
      val lineaTableroAux = reemplazar(lineaTablero, index, '_')
      val tableroAux = reemplazar_lista(tablero, fila, lineaTableroAux)
      
      borrar_horizontal(tableroAux, contador-1, fila, columna)
    }
  }
  
  
  //**********************************************************************************************
  //Cuenta cuantas fichas de un mismo color hay de forma consecutiva en una vertical del tablero
  //**********************************************************************************************
  def vertical(tablero: List[List[Char]], contador: Int, fila: Int, columna: Int):Int = {
    if(fila == 8){
      contador
    }
    else{
      if(tablero(fila)(columna) == tablero(fila+1)(columna)){
        vertical(tablero, contador + 1, fila + 1, columna)
      }else{
        contador
      }
    }
  }
  //**********************************************************************************************
  //Borra n fichas que sean consecutivas y verticales en el tablero
  //**********************************************************************************************
  def borrar_vertical(tablero: List[List[Char]], contador: Int, fila: Int, columna: Int):List[List[Char]] = {
    if(contador == 0){
      tablero
    }
    else{
      //borramos la siguiente posicion que sera (fila + contador)(columna) y seguimos
      val index = fila + contador - 1
      
      val lineaTablero = tablero(index)
      val lineaTableroAux = reemplazar(lineaTablero, columna, '_')
      val tableroAux = reemplazar_lista(tablero, index, lineaTableroAux)
      
      borrar_vertical(tableroAux, contador-1, fila, columna)
    }
  }
  
  
  //**********************************************************************************************
  //Cuenta cuantas fichas tiene la diagonal hacia la derecha y hacia abajo
  // 100
  // 110
  // 011
  //**********************************************************************************************
  def diagonal1Dcha(tablero: List[List[Char]], contador: Int, fila: Int, columna: Int):Int = {
    if(fila < 0 || fila >= 8 || columna < 0 || columna > 8){
      contador
    }else{
      val color = tablero(fila)(columna)
      val diagonalPrincipal = diagonal(tablero, 1, fila, columna, 'd', color)
      val diagonalSecundaria = diagonal(tablero, 1, fila+1, columna, 'd', color)
      
      //Caso en el que la diagonalPrincipal es mas grande, entonces el contador se hallara
      //en funcion de la diagonalSecundaria 
      if((diagonalPrincipal > diagonalSecundaria) && (diagonalSecundaria > 1)){
           ((diagonalSecundaria + 1) + diagonalSecundaria)
      //Caso diagonalSecundaria mas grande o igual, entonces el contador se hallara en
      //funcion de la diagonalPrincipal
      }else if((diagonalPrincipal <= diagonalSecundaria) && (diagonalSecundaria > 1)){
           ((diagonalPrincipal - 1) + diagonalPrincipal)
      }else{
        val valor = diagonalPrincipal + diagonalSecundaria
        if(valor>3){
          1
        }else{
          valor
        }
      }
    }
  }
  
  
  //**********************************************************************************************
  //Cuenta cuantas fichas tiene la diagonal hacia la derecha y hacia arriba
  // 110
  // 011
  // 001
  //**********************************************************************************************
  def diagonal2Dcha(tablero: List[List[Char]], contador: Int, fila: Int, columna: Int):Int = {
    if(fila < 0 || fila >= 8 || columna < 0 || columna > 8){
      contador
    }else{
      val color = tablero(fila)(columna)
      val diagonalPrincipal = diagonal(tablero, 1, fila, columna, 'd', color)
      val diagonalSecundaria = diagonal(tablero, 1, fila, columna+1, 'd', color)
      
      //Caso en el que la diagonalPrincipal es mas grande, entonces el contador se hallara
      //en funcion de la diagonalSecundaria
      if((diagonalPrincipal > diagonalSecundaria) && (diagonalSecundaria > 1)){
         ((diagonalSecundaria + 1) + diagonalSecundaria)
      //Caso diagonalSecundaria mas grande o igual, entonces el contador se hallara en
      //funcion de la diagonalPrincipal
      }else if((diagonalPrincipal <= diagonalSecundaria) && (diagonalSecundaria > 1)){
          ((diagonalPrincipal - 1) + diagonalPrincipal)
      }else{
        val valor = diagonalPrincipal + diagonalSecundaria
        if(valor>3){
          1
        }else{
          valor
        }
      }
    }
  }
  
  
  //**********************************************************************************************
  //Cuenta cuantas fichas tiene la diagonal hacia la izquierda y hacia abajo
  // 001
  // 011
  // 110
  //**********************************************************************************************
  def diagonal1Izq(tablero: List[List[Char]], contador: Int, fila: Int, columna: Int):Int = {
    if(fila < 0 || fila >= 8 || columna < 0 || columna > 8){
      contador
    }else{
      val color = tablero(fila)(columna)
      val diagonalPrincipal = diagonal(tablero, 1, fila, columna, 'i', color)
      val diagonalSecundaria = diagonal(tablero, 1, fila+1, columna, 'i', color)
      
      //Caso en el que la diagonalPrincipal es mas grande, entonces el contador se hallara
      //en funcion de la diagonalSecundaria
      if((diagonalPrincipal > diagonalSecundaria) && (diagonalSecundaria > 1)){
         ((diagonalSecundaria + 1) + diagonalSecundaria)
      //Caso diagonalSecundaria mas grande o igual, entonces el contador se hallara en
      //funcion de la diagonalPrincipal
      }else if((diagonalPrincipal <= diagonalSecundaria) && (diagonalSecundaria > 1)){
          ((diagonalPrincipal - 1) + diagonalPrincipal)
      }else{
        val valor = diagonalPrincipal + diagonalSecundaria
        if(valor>3){
          1
        }else{
          valor
        }
      }
    }
  }
  
  
  //**********************************************************************************************
  //Cuenta cuantas fichas tiene la diagonal hacia la izquierda y hacia arriba
  // 011
  // 110
  // 100
  //**********************************************************************************************
  def diagonal2Izq(tablero: List[List[Char]], contador: Int, fila: Int, columna: Int):Int = {
    if(fila < 0 || fila >= 8 || columna < 0 || columna > 8){
      contador
    }else{
      val color = tablero(fila)(columna)
      val diagonalPrincipal = diagonal(tablero, 1, fila, columna, 'i', color)
      val diagonalSecundaria = diagonal(tablero, 1, fila, columna-1, 'i', color)
      
      //Caso en el que la diagonalPrincipal es mas grande, entonces el contador se hallara
      //en funcion de la diagonalSecundaria 
      if((diagonalPrincipal > diagonalSecundaria) && (diagonalSecundaria > 1)){
         ((diagonalSecundaria + 1) + diagonalSecundaria)
      //Caso diagonalSecundaria mas grande o igual, entonces el contador se hallara en
      //funcion de la diagonalPrincipal
      }else if((diagonalPrincipal <= diagonalSecundaria) && (diagonalSecundaria > 1)){
          ((diagonalPrincipal - 1) + diagonalPrincipal)
      }else{
        val valor = diagonalPrincipal + diagonalSecundaria
        if(valor>3){
          1
        }else{
          valor
        }
      }
    }
  }
  
  
  //**********************************************************************************************
  //Funcion auxiliar que devuelve el numero de fichas que forman una diagonal segun un parámetro
  //**********************************************************************************************
  def diagonal(tablero: List[List[Char]], contador: Int, fila: Int, columna: Int, lado: Char, color: Char):Int = {
    if(fila == 8 || columna == -1 || columna == 9){
      contador
    }
    else if(tablero(fila)(columna) != color){
      0
    }else{
      if(tablero(fila)(columna) != '_'){
        if(lado == 'i'){
          if(columna != 0){
            if(color == tablero(fila+1)(columna-1)){
              diagonal(tablero, contador+1, fila+1, columna-1, lado, color)
            }else{
              contador
            }
          }
          else{
            contador
          }
        }else if(lado == 'd'){
          if(columna != 8){
            if(color == tablero(fila+1)(columna+1)){
              diagonal(tablero, contador+1, fila+1, columna+1, lado, color)
            }else{
              contador
            }
          }
          else{
            contador
          }
        }else{
          contador
        }
      }
      else{
        contador
      }
    }
  }
  
  
  //**********************************************************************************************
  //Borra n fichas consecutivas de una diagonal izquierda
  //**********************************************************************************************
  def borrar_izquierda(tablero: List[List[Char]], contador: Int, fila: Int, columna: Int):List[List[Char]] = {
    if(contador == 0){
      tablero
    }
    else{
      val lineaTablero = tablero(fila)
      val lineaTableroAux = reemplazar(lineaTablero, columna, '_')
      val tableroAux = reemplazar_lista(tablero, fila, lineaTableroAux)
      
      borrar_izquierda(tableroAux, contador-1, fila+1, columna-1)
    }
  }
  
  
  //**********************************************************************************************
  //Borra n fichas consecutivas de una diagonal derecha
  //**********************************************************************************************
  def borrar_derecha(tablero: List[List[Char]], contador: Int, fila: Int, columna: Int):List[List[Char]] = {
    if(contador == 0){
      tablero
    }
    else{
      val lineaTablero = tablero(fila)
      val lineaTableroAux = reemplazar(lineaTablero, columna, '_')
      val tableroAux = reemplazar_lista(tablero, fila, lineaTableroAux)
      
      borrar_derecha(tableroAux, contador-1, fila+1, columna+1)
    }
  }
  
  
  
  
  def main(args: Array[String]){
                               
      iniciar_juego()
     
  }
}