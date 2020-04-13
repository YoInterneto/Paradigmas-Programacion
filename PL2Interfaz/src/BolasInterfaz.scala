
import java.io._
import java.text.SimpleDateFormat
import java.util.Calendar

object Bolas {
  
  def vacio()=List(List('_','_','_','_','_','_','_','_','_'),
                             List('_','_','_','_','_','_','_','_','_'),
                             List('_','_','_','_','_','_','_','_','_'),
                             List('_','_','_','_','_','_','_','_','_'),
                             List('_','_','_','_','_','_','_','_','_'),
                             List('_','_','_','_','_','_','_','_','_'),
                             List('_','_','_','_','_','_','_','_','_'),
                             List('_','_','_','_','_','_','_','_','_'),
                             List('_','_','_','_','_','_','_','_','_'))
  
  
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
  
  
  def colorString(color: Char): String = {
    if(color == 'M'){
      "bola morada"
    }
    else if(color == 'R'){
      "bola roja"
    }
    else if(color == 'V'){
      "bola verde"
    }
    else if(color == 'N'){
      "bola naranja"
    }
    else if(color == 'G'){
      "bola gris"
    }
    else if(color == 'A'){
      "bola amarilla"
    }
    else{
      "cualquier bola"
    }
  }
  
  
  //**********************************************************************************************
  //Funcion que a partir de la lista retornada por la funcion mejor_jugada(), crea un mensaje
  //personalizado para recomendar al usuario el mejor movimiento
  //**********************************************************************************************
  def recomendacion(tablero: List[List[Char]], lista: List[Char]): String ={
    val fila = lista(0).toInt
    val columna = lista(1).toInt
    val colorChar = lista(2)
    val contador = lista(3).toInt
    val tipo = lista(4).toInt
    
    val color = colorString(colorChar)
    
    //Horizontal
    if(tipo == 1 || tipo == 7){
      if(tablero(fila)(columna) == '_'){
        println("AVISO (horizontal) *1 movimiento* \n  -Colocar "+ color +" en posicion ["+ (fila+1) +","+ (columna+1) +"]\n")
        "AVISO (horizontal) *1 movimiento* \n  -Colocar "+ color +" en posicion ["+ (fila+1) +","+ (columna+1) +"]\n"
      }
      else{
        println("AVISO (horizontal) *2 movimientos* \n  -Mover "+ colorString(tablero(fila)(columna)) +" en posicion ["+ (fila+1) +","+ (columna+1) +"]"+
                                                   "\n  -Colocar "+ color +" en posicion ["+ (fila+1) +","+ (columna+1) +"]\n")
                                                   "AVISO (horizontal) *2 movimientos* \n  -Mover "+ colorString(tablero(fila)(columna)) +" en posicion ["+ (fila+1) +","+ (columna+1) +"]"+
                                                   "\n  -Colocar "+ color +" en posicion ["+ (fila+1) +","+ (columna+1) +"]\n"
      }
    }
    //Vertical
    else if(tipo == 2 || tipo == 8){
      if(tablero(fila)(columna) == '_'){
        println("AVISO (vertical) *1 movimiento* \n  -Colocar "+ color +" en posicion ["+ (fila+1) +","+ (columna+1) +"]\n")
        "AVISO (vertical) *1 movimiento* \n  -Colocar "+ color +" en posicion ["+ (fila+1) +","+ (columna+1) +"]\n"
      }
      else{
        println("AVISO (vertical) *2 movimientos* \n  -Mover "+ colorString(tablero(fila)(columna)) +" en posicion ["+ (fila+1) +","+ (columna+1) +"]"+
                                                 "\n  -Colocar "+ color +" en posicion ["+ (fila+1) +","+ (columna+1) +"]\n")
                                                 "AVISO (vertical) *2 movimientos* \n  -Mover "+ colorString(tablero(fila)(columna)) +" en posicion ["+ (fila+1) +","+ (columna+1) +"]"+
                                                 "\n  -Colocar "+ color +" en posicion ["+ (fila+1) +","+ (columna+1) +"]\n"
      }
    }
    //Diagonal izquierda
    else if(tipo == 3 || tipo == 5 || tipo == 9 || tipo == 10 || tipo == 11 || tipo == 12 || tipo == 13 || tipo == 14 || tipo == 15 || tipo == 16){
      if(tablero(fila)(columna) == '_'){
        println("AVISO (diagonal izq.) *1 movimiento* \n  -Colocar "+ color +" en posicion ["+ (fila+1) +","+ (columna+1) +"]\n")
        "AVISO (diagonal izq.) *1 movimiento* \n  -Colocar "+ color +" en posicion ["+ (fila+1) +","+ (columna+1) +"]\n"
      }
      else{
        println("AVISO (diagonal izq.) *2 movimientos* \n  -Mover "+ colorString(tablero(fila)(columna)) +" en posicion ["+ (fila+1) +","+ (columna+1) +"]"+
                                                      "\n  -Colocar "+ color +" en posicion ["+ (fila+1) +","+ (columna+1) +"]\n")
                                                      "AVISO (diagonal izq.) *2 movimientos* \n  -Mover "+ colorString(tablero(fila)(columna)) +" en posicion ["+ (fila+1) +","+ (columna+1) +"]"+
                                                      "\n  -Colocar "+ color +" en posicion ["+ (fila+1) +","+ (columna+1) +"]\n"
      }
    }
    //Diagonal derecha
    else if(tipo == 4 || tipo == 6 || tipo == 17 || tipo == 18 || tipo == 19 || tipo == 20 || tipo == 21 || tipo == 22 || tipo == 23 || tipo == 24){
      if(tablero(fila)(columna) == '_'){
        println("AVISO (diagonal dcha.) *1 movimiento* \n  -Colocar "+ color +" en posicion ["+ (fila+1) +","+ (columna+1) +"]\n")
        "AVISO (diagonal dcha.) *1 movimiento* \n  -Colocar "+ color +" en posicion ["+ (fila+1) +","+ (columna+1) +"]\n"
      }
      else{
        println("AVISO (diagonal dcha.) *2 movimientos* \n  -Mover "+ colorString(tablero(fila)(columna)) +" en posicion ["+ (fila+1) +","+ (columna+1) +"]"+
                                                       "\n  -Colocar "+ color +" en posicion ["+ (fila+1) +","+ (columna+1) +"]\n")
                                                       "AVISO (diagonal dcha.) *2 movimientos* \n  -Mover "+ colorString(tablero(fila)(columna)) +" en posicion ["+ (fila+1) +","+ (columna+1) +"]"+
                                                       "\n  -Colocar "+ color +" en posicion ["+ (fila+1) +","+ (columna+1) +"]\n"
      }
    }
    else{
      println("\nERROR: no se ha podido encontrar el mejor movimiento.\n")
      "\nERROR: no se ha podido encontrar el mejor movimiento.\n"
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
  //Cuenta cuantas fichas de un mismo color hay de forma consecutiva en una horizontal yendo de
  //alante hacia detras
  //**********************************************************************************************
  def horizontalInverso(tablero: List[List[Char]], contador: Int, fila: Int, columna: Int):Int = {
    if(columna==0){
      contador
    }
    else{
      if(tablero(fila)(columna) == tablero(fila)(columna-1)){
        horizontalInverso(tablero, contador + 1, fila, columna - 1)
      }
      else{
        contador
      }
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
  //Cuenta cuantas fichas de un mismo color hay de forma consecutiva en una vertical yendo de
  //abajo hacia arriba
  //**********************************************************************************************
  def verticalInverso(tablero: List[List[Char]], contador: Int, fila: Int, columna: Int):Int = {
    if(fila == 0){
      contador
    }
    else{
      if(tablero(fila)(columna) == tablero(fila-1)(columna)){
        verticalInverso(tablero, contador + 1, fila - 1, columna)
      }else{
        contador
      }
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
  //Estas funciones retornan un contador con el numero de fichas que hay en las posiciones de una
  //diagonal sin tener estas que ser todas iguales. La iteracion de index hace que se puedan 
  //comprobar correctamente
  //**********************************************************************************************
  def diagonal1IzqFija(tablero: List[List[Char]], contador: Int, index: Int, fila: Int, columna: Int, ficha: Char):Int = {
    //Si se pasan de los limites o ya se han visto todas las posiciones 
    if(fila < 0 || fila > 8 || columna < 0 || columna > 8){
      contador
    }
    else{
      //Vamos iterando index para comprobar cada una de las posiciones de la diagonal
      if(index == 0){
        if(fila != 8){
          if(ficha == tablero(fila+1)(columna)){
            diagonal1IzqFija(tablero, contador+1, index+1, fila, columna, ficha)
          }
          else{ diagonal1IzqFija(tablero, contador, index+1, fila, columna, ficha) }
        }
        else{ 1 }
      }
      else if(index == 1){
        if(fila != 8 && columna != 0){
          if(ficha == tablero(fila+1)(columna-1)){
            diagonal1IzqFija(tablero, contador+1, index+1, fila, columna, ficha)
          }
          else{ diagonal1IzqFija(tablero, contador, index+1, fila, columna, ficha) }
        }
        else{ 1 }
        
      }
      else if(index == 2){
        if(fila <= 6 && columna != 0){
          if(ficha == tablero(fila+2)(columna-1)){
            diagonal1IzqFija(tablero, contador+1, index+1, fila, columna, ficha)
          }
          else{ diagonal1IzqFija(tablero, contador, index+1, fila, columna, ficha) }
        }
        else{ 1 }
        
      }
      else if(index == 3){
        if(fila <= 6 && columna >= 2){
          if(ficha == tablero(fila+2)(columna-2)){
            diagonal1IzqFija(tablero, contador+1, index+1, fila, columna, ficha)
          }
          else{ diagonal1IzqFija(tablero, contador, index+1, fila, columna, ficha) }
        }
        else{ 1 }
        
      }
      else if(index == 4){
        if(ficha == tablero(fila)(columna)){
            diagonal1IzqFija(tablero, contador+1, index+1, fila, columna, ficha)
          }
          else{ contador }
        
      }else{
        contador
      }
    }
  }
  //**********************************************************************************************
  def diagonal2IzqFija(tablero: List[List[Char]], contador: Int, index: Int, fila: Int, columna: Int, ficha: Char):Int = {
    //Si se pasan de los limites o ya se han visto todas las posiciones 
    if(fila < 0 || fila > 8 || columna < 0 || columna > 8){
      contador
    }
    else{
      //Vamos iterando index para comprobar cada una de las posiciones de la diagonal
      if(index == 0){
        if(columna != 0){
            if(ficha == tablero(fila)(columna-1)){
              diagonal2IzqFija(tablero, contador+1, index+1, fila, columna, ficha)
            }
            else{ diagonal2IzqFija(tablero, contador, index+1, fila, columna, ficha) }
          }
          else{ 1 }
        
      }
      else if(index == 1){
        if(fila != 8 && columna != 0){
          if(ficha == tablero(fila+1)(columna-1)){
            diagonal2IzqFija(tablero, contador+1, index+1, fila, columna, ficha)
          }
          else{ diagonal2IzqFija(tablero, contador, index+1, fila, columna, ficha) }
        }
        else{ 1 }
        
      }
      else if(index == 2){
        if(fila != 8 && columna >= 2){
          if(ficha == tablero(fila+1)(columna-2)){
            diagonal2IzqFija(tablero, contador+1, index+1, fila, columna, ficha)
          }
          else{ diagonal2IzqFija(tablero, contador, index+1, fila, columna, ficha) }
        }
        else{ 1 }
        
      }
      else if(index == 3){
        if(fila <= 6 && columna >= 2){
          if(ficha == tablero(fila+2)(columna-2)){
            diagonal2IzqFija(tablero, contador+1, index+1, fila, columna, ficha)
          }
          else{ diagonal2IzqFija(tablero, contador, index+1, fila, columna, ficha) }
        }
        else{ 1 }
        
      }
      else if(index == 4){
        if(ficha == tablero(fila)(columna)){
            diagonal2IzqFija(tablero, contador+1, index+1, fila, columna, ficha)
          }
          else{ contador }
        
      }else{
        contador
      }
    }
  }
  //**********************************************************************************************
  def diagonal1DchaFija(tablero: List[List[Char]], contador: Int, index: Int, fila: Int, columna: Int, ficha: Char):Int = {
    //Si se pasan de los limites o ya se han visto todas las posiciones 
    if(fila < 0 || fila > 8 || columna < 0 || columna > 8){
      contador - 1
    }
    else{
      //Vamos iterando index para comprobar cada una de las posiciones de la diagonal
      if(index == 0){
        if(fila != 8 ){
          if(ficha == tablero(fila+1)(columna)){
            diagonal1DchaFija(tablero, contador+1, index+1, fila, columna, ficha)
          }
          else{ diagonal1DchaFija(tablero, contador, index+1, fila, columna, ficha) }
        }
        else{ 1 }
        
      }
      else if(index == 1){
        if(fila != 8 && columna != 8){
          if(ficha == tablero(fila+1)(columna+1)){
            diagonal1DchaFija(tablero, contador+1, index+1, fila, columna, ficha)
          }
          else{ diagonal1DchaFija(tablero, contador, index+1, fila, columna, ficha) }
        }
        else{ 1 }
        
      }
      else if(index == 2){
        if(fila <= 6 && columna != 8){
          if(ficha == tablero(fila+2)(columna+1)){
            diagonal1DchaFija(tablero, contador+1, index+1, fila, columna, ficha)
          }
          else{ diagonal1DchaFija(tablero, contador, index+1, fila, columna, ficha) }
        }
        else{ 1 }
        
      }
      else if(index == 3){
        if(fila <= 6 && columna <= 6){
          if(ficha == tablero(fila+2)(columna+2)){
            diagonal1DchaFija(tablero, contador+1, index+1, fila, columna, ficha)
          }
          else{ diagonal1DchaFija(tablero, contador, index+1, fila, columna, ficha) }
        }
        else{ 1 }
        
      }
      else if(index == 4){
        if(ficha == tablero(fila)(columna)){
            diagonal1DchaFija(tablero, contador+1, index+1, fila, columna, ficha)
        }
        else{ contador }
        
      }else{
        contador
      }
    }
  }
  //**********************************************************************************************
  def diagonal2DchaFija(tablero: List[List[Char]], contador: Int, index: Int, fila: Int, columna: Int, ficha: Char):Int = {
    //Si se pasan de los limites o ya se han visto todas las posiciones 
    if(fila < 0 || fila > 8 || columna < 0 || columna > 8){
      contador
    }
    else{
      //Vamos iterando index para comprobar cada una de las posiciones de la diagonal
      if(index == 0){
        if(columna != 8){
            if(ficha == tablero(fila)(columna+1)){
              diagonal2DchaFija(tablero, contador+1, index+1, fila, columna, ficha)
            }
            else{ diagonal2DchaFija(tablero, contador, index+1, fila, columna, ficha) }
          }
          else{ 1 }
      }
      else if(index == 1){
        if(fila != 8 && columna != 8){
          if(ficha == tablero(fila+1)(columna+1)){
            diagonal2DchaFija(tablero, contador+1, index+1, fila, columna, ficha)
          }
          else{ diagonal2DchaFija(tablero, contador, index+1, fila, columna, ficha) }
        }
        else{ 1 }
      }
      else if(index == 2){
        if(fila != 8 && columna <= 6){
          if(ficha == tablero(fila+1)(columna+2)){
            diagonal2DchaFija(tablero, contador+1, index+1, fila, columna, ficha)
          }
          else{ diagonal2DchaFija(tablero, contador, index+1, fila, columna, ficha) }
        }
        else{ 1 }
      }
      else if(index == 3){
        if(fila <= 6 && columna <= 6){
          if(ficha == tablero(fila+2)(columna+2)){
            diagonal2DchaFija(tablero, contador+1, index+1, fila, columna, ficha)
          }
          else{ diagonal2DchaFija(tablero, contador, index+1, fila, columna, ficha) }
        }
        else{ 1 }
      }
      else if(index == 4){
        if(ficha == tablero(fila)(columna)){
            diagonal2DchaFija(tablero, contador+1, index+1, fila, columna, ficha)
          }
          else{ contador }
      }else{
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
  
  
  //**********************************************************************************************
  //Devuelve una lista con la informacion del mejor movimiento posible que el jugador puede 
  //realizar en el siguiente o siguientes movimientos iterando y recorriendo la matriz posicion por
  //posicion en cada posicion comprobando cada uno de los colores, la lista tiene esta informacion:
  //                --- List(fila, columna, color, contador, tipo) ---
  //El tipo se refiere a 1(horizontal), 2(vertical), 3(diagonalizq1), 4(diagonaldcha1), 
  //                     5(diagonalizq2), 6(diagonaldcha2), 7(mitadhorizontal), 8(mitadvertical)
  //**********************************************************************************************
  def mejor_jugada(tablero: List[List[Char]]):List[Char] = { mejor_jugadaAux(tablero, 0, 0, 10, 10, 0, '_', 0, 'A') }
  def mejor_jugadaAux(tablero: List[List[Char]], fila: Int, columna: Int, filaMax: Int, columnaMax: Int, contadorMax: Int, colorMax: Char, tipo: Int, colorElegido: Char):List[Char] = {
    //Si se ha recorrido el tablero retornamos la lista con toda la informacion necesaria
    if(fila == 9){
      val filaFinal = filaMax.toChar
      val columnaFinal = columnaMax.toChar
      val contadorFinal = contadorMax.toChar
      val tipoFinal = tipo.toChar
      
      val listaMaximo = List(filaFinal, columnaFinal, colorMax, contadorFinal, tipoFinal)
      
      listaMaximo
    }
    else if(columna == 9){
       mejor_jugadaAux(tablero, fila+1, 0, filaMax, columnaMax, contadorMax, colorMax, tipo, colorElegido)
    }
    //Si la funcion siguiente nos retorna este caracter quiere decir que ya ha llegado al final de la lista y entonces se comprueba
    //la siguiente posicion de la matriz empezando de nuevo por el color 'A'
    else if(colorElegido == '_'){
      mejor_jugadaAux(tablero, fila, columna+1, filaMax, columnaMax, contadorMax, colorMax, tipo, 'A')
    }
    else{
      
      val siguienteColor = siguiente(colorElegido)
      
      //Si en la posicion esta el mismo color que el que queremos comprobar no lo comprobamos y seguimos con el siguiente color
      if(tablero(fila)(columna) == colorElegido){
        mejor_jugadaAux(tablero, fila, columna, filaMax, columnaMax, contadorMax, colorMax, tipo, siguienteColor)
      //Si en la posicion hay otro color o esta vacio pasamos a comprobar con el color correspondiente que toque en esta iteracion
      //reemplazando el color en el tablero y viendo como serian los contadores
      }else{
        //Tablero con la ficha de color para comprobar si es buena opcion
        val lineaTablero = tablero(fila)
        val lineaTableroAux = reemplazar(lineaTablero, columna, colorElegido)
        val tableroAux = reemplazar_lista(tablero, fila, lineaTableroAux)
        
        //Contadores de vertical, horizontal y diagonal para ese tablero
        /* Tipo 1 */ val horizontal_cont = horizontal(tableroAux, 1, fila, columna)
        /* Tipo 2 */ val vertical_cont = vertical(tableroAux, 1, fila, columna)
        /* Tipo 3 */ val diagonal1Izq_cont = diagonal1Izq(tableroAux, 0, fila, columna)
        /* Tipo 4 */ val diagonal1Dcha_cont = diagonal1Dcha(tableroAux, 0, fila, columna)
        /* Tipo 5 */ val diagonal2Izq_cont = diagonal2Izq(tableroAux, 0, fila, columna)
        /* Tipo 6 */ val diagonal2Dcha_cont = diagonal2Dcha(tableroAux, 0, fila, columna)
        /* Tipo 7 */ val horizontalMedio_cont = (horizontal_cont + horizontalInverso(tableroAux, 1, fila, columna)) - 1 //Restamos 1 debido a que 
        /* Tipo 8 */ val verticalMedio_cont = (vertical_cont + verticalInverso(tableroAux, 1, fila, columna)) - 1       //cuenta dos veces la misma ficha
        
        /* Tipo 9 */ val izqArriba1_cont = diagonal2IzqFija(tableroAux, 0, 0, fila, columna+1, colorElegido)
        /* Tipo 10*/ val izqArriba2_cont = diagonal2IzqFija(tableroAux, 0, 0, fila-1, columna+2, colorElegido)
        /* Tipo 11*/ val izqAbajo1_cont = diagonal1IzqFija(tableroAux, 0, 0, fila-1, columna, colorElegido)
        /* Tipo 12*/ val izqAbajo2_cont = diagonal1IzqFija(tableroAux, 0, 0, fila-2, columna+1, colorElegido)
        /* Tipo 13*/ val izqMedioArriba1_cont = diagonal2IzqFija(tableroAux, 0, 0, fila-1, columna+1, colorElegido)
        /* Tipo 14*/ val izqMedioArriba2_cont = diagonal2IzqFija(tableroAux, 0, 0, fila-2, columna+2, colorElegido)
        /* Tipo 15*/ val izqMedioAbajo1_cont = diagonal1IzqFija(tableroAux, 0, 0, fila-1, columna+1, colorElegido)
        /* Tipo 16*/ val izqMedioAbajo2_cont = diagonal1IzqFija(tableroAux, 0, 0, fila-2, columna+2, colorElegido)
        
        /* Tipo 17*/ val dchaArriba1_cont = diagonal2DchaFija(tableroAux, 0, 0, fila, columna-1, colorElegido)
        /* Tipo 18*/ val dchaArriba2_cont = diagonal2DchaFija(tableroAux, 0, 0, fila-1, columna-2, colorElegido)
        /* Tipo 19*/ val dchaAbajo1_cont = diagonal1DchaFija(tableroAux, 0, 0, fila-1, columna, colorElegido)
        /* Tipo 20*/ val dchaAbajo2_cont = diagonal1DchaFija(tableroAux, 0, 0, fila-2, columna-1, colorElegido)
        /* Tipo 21*/ val dchaMedioArriba1_cont = diagonal2DchaFija(tableroAux, 0, 0, fila-1, columna-1, colorElegido)
        /* Tipo 22*/ val dchaMedioArriba2_cont = diagonal2DchaFija(tableroAux, 0, 0, fila-2, columna-2, colorElegido)
        /* Tipo 23*/ val dchaMedioAbajo1_cont = diagonal1DchaFija(tableroAux, 0, 0, fila-1, columna-1, colorElegido)
        /* Tipo 24*/ val dchaMedioAbajo2_cont = diagonal1DchaFija(tableroAux, 0, 0, fila-2, columna-2, colorElegido)
        
        
        val contadores = List(horizontal_cont, vertical_cont, diagonal1Izq_cont, diagonal1Dcha_cont, diagonal2Izq_cont, 
                              diagonal2Dcha_cont, horizontalMedio_cont, verticalMedio_cont, izqArriba1_cont, izqArriba2_cont,
                              izqAbajo1_cont, izqAbajo2_cont, dchaArriba1_cont, dchaArriba2_cont, dchaAbajo1_cont, dchaAbajo2_cont,
                              izqMedioArriba1_cont, izqMedioArriba2_cont, izqMedioAbajo1_cont, izqMedioAbajo2_cont,
                              dchaMedioArriba1_cont, dchaMedioArriba2_cont, dchaMedioAbajo1_cont, dchaMedioAbajo2_cont)
        //Posicion 0 contador, posicion 1 tipo                   
        val maximoContador = maximo_lista(contadores) 
          
        val contadorElegido = maximoContador(0)
        val tipoElegido = maximoContador(1)
        
        //Son el numero de fichas del color elegido que pueden moverse
        val fichasPosibles = contar_color(tablero, colorElegido) - (contadorElegido - 1)
        
        //Si alguno de los contadores de colocar la ficha en esa posicion es mayor que el que estaba este sera
        //la mejor eleccion
        if((contadorElegido > contadorMax) || (contadorElegido >= contadorMax && (tablero(fila)(columna) == '_'))){
          //Solo se guardara como mejor eleccion, si es posible hacer ese mocvimiento, es decir, que en el tablero haya
          //una ficha de el color elegido que pueda moverse
          if(fichasPosibles > 0){
            mejor_jugadaAux(tablero, fila, columna, fila, columna, contadorElegido, colorElegido, tipoElegido, siguienteColor)
          }
          else{
            mejor_jugadaAux(tablero, fila, columna, filaMax, columnaMax, contadorMax, colorMax, tipo, siguienteColor)
          }
        }
        //Si no son mayores los contadores que el maximo guardado seguimos iterando
        else{
          mejor_jugadaAux(tablero, fila, columna, filaMax, columnaMax, contadorMax, colorMax, tipo, siguienteColor)
        }
      }
    }
  }
  
  
  //**********************************************************************************************
  //Devuelve el siguiente color a comprobar a partir de un color dado
  //**********************************************************************************************
  def siguiente(anterior: Char): Char = { siguienteAux(anterior, 0) }
  def siguienteAux(anterior: Char, contador: Int): Char = {
    val colores = List('A','N','R','V','M','G')
    //Si hemos llegado al ultimo elemento de la lista mandamos una "señal" para avisar de ello
    if(contador == colores.length-1){
      '_'
    }
    //Para los demas casos seguimos comprobando hasta dar con el elemento del que queremos saber el siguiente
    //y una vez lo encontramos devolvemos el siguiente
    else{
      if(colores(contador) == anterior){
        colores(contador + 1)
      }
      else{
        siguienteAux(anterior, contador+1)
      }
    }
  }
  
  
  //**********************************************************************************************
  //Devuelve una lista que tiene como primer numero el maximo de todos los valores de una lista y
  //como segundo numero la posicion que tiene
  //Se usa para saber el maximo de todos los contadores ademas de si ese contador es de una 
  //horizontal, vertical, diagonal
  //**********************************************************************************************
  def maximo_lista(listaContadores: List[Int]):List[Int] = { maximo_listaAux(listaContadores, 0, 0, 1)}
  def maximo_listaAux(listaContadores: List[Int],contador: Int, maximo: Int, tipo: Int):List[Int] = {
    if(contador == listaContadores.length){
      val listaFinal = List(maximo, tipo)
      listaFinal
    }
    else{
      val posicionValor = listaContadores(contador)
      //Si el valor de la lista es mayor que el que habia guardado se guarda su posicion y valor
      if(posicionValor > maximo){
        maximo_listaAux(listaContadores, contador+1, posicionValor, contador+1)
      }
      //Si no es mayor se sigue iterando
      else{
        maximo_listaAux(listaContadores, contador+1, maximo, tipo)
      }
    }
  }
  

  //**********************************************************************************************
  //Cuenta el numero de ocurrencias de un color en el tablero
  //**********************************************************************************************
  def contar_color(tablero: List[List[Char]], color: Char): Int = {
    contar_colorAux(tablero, color, 0, 0, 0)
  }
  def contar_colorAux(tablero: List[List[Char]], color: Char, contador: Int, fila: Int, columna: Int):Int = {
    if(fila == 9){
      contador
    }
    else{
      if(columna == 9){
        contar_colorAux(tablero, color, contador, fila+1, 0)
      }
      else{
        if(tablero(fila)(columna) == color){
          contar_colorAux(tablero, color, contador+1, fila, columna+1)
        }
        else{
          contar_colorAux(tablero, color, contador, fila, columna+1)
        }
      }
    }
  }
}