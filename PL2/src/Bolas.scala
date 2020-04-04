
object Bolas {
  
  //Se llena el tablero inicialmente vacio aleatoriamente                    
  def llenar_tablero_inicial(tablero: List[List[Char]], cont: Int):List[List[Char]]={
    
    val lista = List('A','N','R','V','M','G')//Posibles colores
    
    val r = scala.util.Random
    val posicion1 = r.nextInt(9)
    val posicion2 = r.nextInt(9)
    val color = r.nextInt(6)
    val valor = lista(color)
    
    
    if (cont==9){//Ya se han llenado los 9
      return tablero
    }
    else{//Si no se han llenado los 9
      if (tablero(posicion1)(posicion2) == '_'){//Si esa posicion no se ha reemplazado
        val tablero_inicial = reemplazar(tablero(posicion1), posicion2, valor) //tablero(posicion1).updated(posicion2, valor)
        val tablero_inicial_final = reemplazar_lista(tablero, posicion1, tablero_inicial)//tablero.updated(posicion1, tablero_inicial)
        llenar_tablero_inicial(tablero_inicial_final,cont+1)//Llamamos a la funcion con contador + 1
        
      }
      else {llenar_tablero_inicial(tablero,cont)}//Si la posicion esta reemplazada volvemos otra vez
      
   }
        
  }
  
  //Comprueba que fila y columna no se pasen de los limites
  def comprobar_limite(x: Int, y: Int):Boolean={
    
    if(x<=8 && x>=0 && y>=0 && y<=8){
      true
    }
    else{
      println("Se ha pasado de los limites del tablero")
      false
    }
  }
  
  //Escoge la bola del tablero que quiere mover
  def escoger_bola(tablero: List[List[Char]],puntuacion:Int){
     
     if(final_partida(tablero, 0, 0)){
       println("Tablero completo, partida finalizada")
     }
     else{
       print("Introduzca la fila de la bola que quiere utilizar(1-9): ")
       val xIn = scala.io.StdIn.readInt()
       print("Introduzca la columna de la bola que quiere utilizar(1-9): ")
       val yIn = scala.io.StdIn.readInt()
       
       val x = xIn - 1
       val y = yIn - 1
       
       if(comprobar_limite(x,y)){
       val bola = tablero(x)(y)
         if(bola != '_'){//Si en el hueco hay una bola
           println("Bola escogida:"+ bola)
           mover_bola(tablero,bola,x,y,puntuacion)
         }
         else{
           println("ERROR: Posicion vacia. Intente otra posicion. ")
           escoger_bola(tablero,puntuacion)
         }
       }
       else{
         escoger_bola(tablero,puntuacion)
       }
     }  
  }
  
  //Mueve la bola escogida a la posicion que le introducimos
  def mover_bola(tablero: List[List[Char]], bola: Char, x: Int, y: Int, puntuacion: Int){
    
    print("Introduzca la fila donde la quiere introducir(1-9): ")
    val xIn = scala.io.StdIn.readInt()
    print("Introduzca la columna donde la quiere introducir(1-9): ")
    val yIn = scala.io.StdIn.readInt()
    
    val x2 = xIn - 1
    val y2 = yIn - 1
    
    if(comprobar_limite(x2, y2)){
      
      val hueco = tablero(x2)(y2)
      
      if(hueco == '_'){//Si el hueco donde queremos introducir esta vacio
        val fila_nueva = reemplazar(tablero(x2),y2,bola)//tablero(x2).updated(y2, bola) 
        val tablero_sin_hueco = reemplazar_lista(tablero, x2, fila_nueva) //tablero.updated(x2, tablero_inicial)
        val tablero_hueco = reemplazar(tablero_sin_hueco(x), y, '_') //tablero_sin_hueco(x).updated(y, '_')//Donde estaba la bola antes, ahora esta vacio
        val tablero_con_hueco = reemplazar_lista(tablero_sin_hueco, x, tablero_hueco)//tablero_sin_hueco.updated(x, tablero_hueco)//Lo reemplazamos
        
        //escoger_bola(tablero_con_hueco)
        val tablero_sig_turno = rellenar_turno(tablero_con_hueco, 0)
        
        val puntuacionAux = calcular_puntuacion(tablero_sig_turno, 0, 0, 0) * 75
        val puntuacion_acumulada = puntuacion + puntuacionAux
        println("Puntuacion acumulada: "+ puntuacion_acumulada)
        val tablero_comprobado = comprobar_tablero(tablero_sig_turno)
        
        println("\n*** ANTES ***")
        mostrar_tablero(tablero_sig_turno)
        println("\n*** comprobado ***\n")
        mostrar_tablero(tablero_comprobado)
        
        
        val lista_movimientos = mejor_jugada(tablero_comprobado)
        recomendacion(tablero_comprobado, lista_movimientos)
        
        escoger_bola(tablero_comprobado,puntuacion_acumulada)
         
      }
      else{
        println("ERROR: Posicion ocupada. Intente otra posicion.")
        mover_bola(tablero,bola,x,y,puntuacion)
      }
    }
    else{
      mover_bola(tablero,bola,x,y,puntuacion)
    }
    
    
  }
  
  
  def recomendacion(tablero: List[List[Char]], lista: List[Char]){
    val fila = lista(0).toInt
    val columna = lista(1).toInt
    val color = lista(2)
    val contador = lista(3).toInt
    val tipo = lista(4).toInt
    
    //Horizontal
    if(tipo == 1 || tipo == 7){
      if(tablero(fila)(columna) == '_'){
        println("AVISO (horizontal) *1 movimiento* \n  -Colocar "+ color +" en posicion ["+ (fila+1) +","+ (columna+1) +"]")
      }
      else{
        println("AVISO (horizontal) *2 movimientos* \n  -Mover "+ tablero(fila)(columna) +" en posicion ["+ (fila+1) +","+ (columna+1) +"]"+
                                                   "\n  -Colocar "+ color +" en posicion ["+ (fila+1) +","+ (columna+1) +"]")
      }
    }
    //Vertical
    else if(tipo == 2 || tipo == 8){
      if(tablero(fila)(columna) == '_'){
        println("AVISO (vertical) *1 movimiento* \n  -Colocar "+ color +" en posicion ["+ (fila+1) +","+ (columna+1) +"]")
      }
      else{
        println("AVISO (vertical) *2 movimientos* \n  -Mover "+ tablero(fila)(columna) +" en posicion ["+ (fila+1) +","+ (columna+1) +"]"+
                                                 "\n  -Colocar "+ color +" en posicion ["+ (fila+1) +","+ (columna+1) +"]")
      }
    }
    //Diagonal izquierda
    else if(tipo == 3 || tipo == 5){
      if(tablero(fila)(columna) == '_'){
        println("AVISO (diagonal izq.) *1 movimiento* \n  -Colocar "+ color +" en posicion ["+ (fila+1) +","+ (columna+1) +"]")
      }
      else{
        println("AVISO (diagonal izq.) *2 movimientos* \n  -Mover "+ tablero(fila)(columna) +" en posicion ["+ (fila+1) +","+ (columna+1) +"]"+
                                                      "\n  -Colocar "+ color +" en posicion ["+ (fila+1) +","+ (columna+1) +"]")
      }
    }
    //Diagonal derecha
    else if(tipo == 4 || tipo == 6){
      if(tablero(fila)(columna) == '_'){
        println("AVISO (diagonal dcha.) *1 movimiento* \n  -Colocar "+ color +" en posicion ["+ (fila+1) +","+ (columna+1) +"]")
      }
      else{
        println("AVISO (diagonal dcha.) *2 movimientos* \n  -Mover "+ tablero(fila)(columna) +" en posicion ["+ (fila+1) +","+ (columna+1) +"]"+
                                                       "\n  -Colocar "+ color +" en posicion ["+ (fila+1) +","+ (columna+1) +"]")
      }
    }
    else{
      println("ERROR: no se ha podido encontrar el mejor movimiento")
    }
    
  }
  
  
  
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
              mostrar_tablero(tableroAux)
              
              calcular_puntuacion(tableroAux, puntuacion + vertical_cont, fila, columna+1)
            //Borramos las fichas diagonal izquierda, con las fichas abajo
            }else if(diagonal1Izq_cont >= 5){
              val diagonalSecundaria: Int = diagonal1Izq_cont / 2
              val diagonalPrincipal = diagonal1Izq_cont - diagonalSecundaria
              
              val tableroAux = borrar_izquierda(tablero, diagonalPrincipal, fila, columna)
              val tableroAux1 = borrar_izquierda(tableroAux, diagonalSecundaria, fila+1, columna)
              mostrar_tablero(tableroAux1)
              
              calcular_puntuacion(tableroAux1, puntuacion + diagonal1Izq_cont, fila, columna+1)
            //Borramos las fichas diagonal derecha, con las fichas abajo  
            }else if(diagonal1Dcha_cont >= 5){
              val diagonalSecundaria: Int = diagonal1Dcha_cont / 2
              val diagonalPrincipal = diagonal1Dcha_cont - diagonalSecundaria
              
              val tableroAux = borrar_derecha(tablero, diagonalPrincipal, fila, columna)
              val tableroAux1 = borrar_derecha(tableroAux, diagonalSecundaria, fila+1, columna)
              mostrar_tablero(tableroAux1)
              
              calcular_puntuacion(tableroAux1, puntuacion + diagonal1Dcha_cont, fila, columna+1)
            //Borramos las fichas diagonal izquierda, con las fichas arriba  
            }else if(diagonal2Izq_cont >= 5){
              val diagonalSecundaria: Int = diagonal2Izq_cont / 2
              val diagonalPrincipal = diagonal2Izq_cont - diagonalSecundaria
              
              val tableroAux = borrar_izquierda(tablero, diagonalPrincipal, fila, columna)
              val tableroAux1 = borrar_izquierda(tableroAux, diagonalSecundaria, fila, columna-1)
              mostrar_tablero(tableroAux1)
              
              calcular_puntuacion(tableroAux1, puntuacion + diagonal2Izq_cont, fila, columna+1)
            //Borramos las fichas diagonal derecha, con las fichas arriba  
            }else{
              val diagonalSecundaria: Int = diagonal2Dcha_cont / 2
              val diagonalPrincipal = diagonal2Dcha_cont - diagonalSecundaria
              
              val tableroAux = borrar_derecha(tablero, diagonalPrincipal, fila, columna)
              val tableroAux1 = borrar_derecha(tableroAux, diagonalSecundaria, fila, columna+1)
              mostrar_tablero(tableroAux1)
              
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
  
  //En cada turno se introducen 3 bolas aleatorias
  def rellenar_turno(tablero:List[List[Char]],contador:Int):List[List[Char]]={//Para rellenar las 3 en cada turno

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
    //Si queda un hueco lo rellena
      if(huecos==1){
        if(tablero(posicion1)(posicion2)=='_'){//Si esa posicion no se ha reemplazado
          val tablero_inicial = reemplazar(tablero(posicion1), posicion2, valor)//tablero(posicion1).updated(posicion2, valor)
          val tablero_inicial_final = reemplazar_lista(tablero, posicion1, tablero_inicial)//tablero.updated(posicion1, tablero_inicial)
          tablero_inicial_final//Si solo quedaba un hueco, se completa y devuelve el tablero final
      }
        else {
          rellenar_turno(tablero,contador)
        }
      }
      
      else{
        if(tablero(posicion1)(posicion2)=='_'){//Si esa posicion no se ha reemplazado
          val tablero_inicial = reemplazar(tablero(posicion1), posicion2, valor)//tablero(posicion1).updated(posicion2, valor)
          val tablero_inicial_final = reemplazar_lista(tablero, posicion1, tablero_inicial)//tablero.updated(posicion1, tablero_inicial)
          rellenar_turno(tablero_inicial_final,contador+1)//Llamamos a la funcion con contador +1
      }
        else {
          rellenar_turno(tablero,contador)
        }
      }   
    }
  }
  
  
  //Comprueba que se ha terminado la partida (tablero completo)
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
  
  
  //Funcion auxiliar para saber los huecos restantes, se usara en rellenear_turno
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
  
  
  //Mostrar el tablero bien, asi es un poco guarro
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
  
  //Funcion que sustituye al updated
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
          println("("+ fila +" x "+ columna+")")
          //Borramos las fichas horizontales
          if(horizontal_cont >= 5){
            val tableroAux = borrar_horizontal(tablero, horizontal_cont, fila, columna) //Tablero borrando columna + horizontal_cont posiciones
            mostrar_tablero(tableroAux)
            
            comprobar_tableroAux(tableroAux, fila, columna+1)
          //Borramos las fichas verticales
          }else if(vertical_cont >= 5){
            val tableroAux = borrar_vertical(tablero, vertical_cont, fila, columna) //Tablero borrando fila + vertical_cont posiciones
            mostrar_tablero(tableroAux)
            
            comprobar_tableroAux(tableroAux, fila, columna+1)
          //Borramos las fichas diagonal izquierda, con las fichas abajo
          }else if(diagonal1Izq_cont >= 5){
            val diagonalSecundaria: Int = diagonal1Izq_cont / 2
            val diagonalPrincipal = diagonal1Izq_cont - diagonalSecundaria
            
            val tableroAux = borrar_izquierda(tablero, diagonalPrincipal, fila, columna)
            val tableroAux1 = borrar_izquierda(tableroAux, diagonalSecundaria, fila+1, columna)
            mostrar_tablero(tableroAux1)
            
            comprobar_tableroAux(tableroAux1, fila, columna+1)
          //Borramos las fichas diagonal derecha, con las fichas abajo  
          }else if(diagonal1Dcha_cont >= 5){
            val diagonalSecundaria: Int = diagonal1Dcha_cont / 2
            val diagonalPrincipal = diagonal1Dcha_cont - diagonalSecundaria
            
            val tableroAux = borrar_derecha(tablero, diagonalPrincipal, fila, columna)
            val tableroAux1 = borrar_derecha(tableroAux, diagonalSecundaria, fila+1, columna)
            mostrar_tablero(tableroAux1)
            
            comprobar_tableroAux(tableroAux1, fila, columna+1)
          //Borramos las fichas diagonal izquierda, con las fichas arriba  
          }else if(diagonal2Izq_cont >= 5){
            val diagonalSecundaria: Int = diagonal2Izq_cont / 2
            val diagonalPrincipal = diagonal2Izq_cont - diagonalSecundaria
            
            val tableroAux = borrar_izquierda(tablero, diagonalPrincipal, fila, columna)
            val tableroAux1 = borrar_izquierda(tableroAux, diagonalSecundaria, fila, columna-1)
            mostrar_tablero(tableroAux1)
            
            comprobar_tableroAux(tableroAux1, fila, columna+1)
          //Borramos las fichas diagonal derecha, con las fichas arriba  
          }else{
            val diagonalSecundaria: Int = diagonal2Dcha_cont / 2
            val diagonalPrincipal = diagonal2Dcha_cont - diagonalSecundaria
            
            val tableroAux = borrar_derecha(tablero, diagonalPrincipal, fila, columna)
            val tableroAux1 = borrar_derecha(tableroAux, diagonalSecundaria, fila, columna+1)
            mostrar_tablero(tableroAux1)
            
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
    if(fila == 8){
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
        contador
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
    if(fila == 8){
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
        contador
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
    if(fila == 8){
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
        contador
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
    if(fila == 8){
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
        contador
      }
    }
  }
  
  
  //**********************************************************************************************
  //Funcion auxiliar que devuelve el numero de fichas que forman una diagonal segun un parámetro
  //**********************************************************************************************
  def diagonal(tablero: List[List[Char]], contador: Int, fila: Int, columna: Int, lado: Char, color: Char):Int = {
    if(fila == 8 || columna == -1 || columna == 9){
      contador
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
        /* Tipo 3 */ val diagonal1Izq_cont = diagonal1Izq(tableroAux, 1, fila, columna)
        /* Tipo 4 */ val diagonal1Dcha_cont = diagonal1Dcha(tableroAux, 1, fila, columna)
        /* Tipo 5 */ val diagonal2Izq_cont = diagonal2Izq(tableroAux, 1, fila, columna)
        /* Tipo 6 */ val diagonal2Dcha_cont = diagonal2Dcha(tableroAux, 1, fila, columna)
        /* Tipo 7 */ val horizontalMedio_cont = (horizontal_cont + horizontalInverso(tableroAux, 1, fila, columna)) - 1 //Restamos 1 debido a que 
        /* Tipo 8 */ val verticalMedio_cont = (vertical_cont + verticalInverso(tableroAux, 1, fila, columna)) - 1       //cuenta dos veces la misma ficha
        
        
        val contadores = List(horizontal_cont, vertical_cont, diagonal1Izq_cont, diagonal1Dcha_cont, diagonal2Izq_cont, 
                              diagonal2Dcha_cont, horizontalMedio_cont, verticalMedio_cont)
        val maximoContador = maximo_lista(contadores) //Posicion 0 contador, posicion 1 tipo
          
        val contadorElegido = maximoContador(0)
        val tipoElegido = maximoContador(1)
        
        //Son el numero de fichas del color elegido que pueden moverse
        val fichasPosibles = contar_color(tablero, colorElegido) - (contadorElegido - 1)
        
        //Si alguno de los contadores de colocar la ficha en esa posicion es mayor que el que estaba este sera
        //la mejor eleccion
        //if((contadorElegido > contadorMax) || (contadorElegido >= contadorMax && (tablero(fila)(columna) == '_'))){
        if(contadorElegido > contadorMax){
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

  
  
  
  def main(args: Array[String]){
      val tablero_vacio = List(List('_','_','_','_','_','_','_','_','_'),
                               List('_','_','_','_','_','_','_','_','_'),
                               List('_','_','_','_','_','_','_','_','_'),
                               List('_','_','_','_','_','_','_','_','_'),
                               List('_','_','_','_','_','_','_','_','_'),
                               List('_','_','_','_','_','_','_','_','_'),
                               List('_','_','_','_','_','_','_','_','_'),
                               List('_','_','_','_','_','_','_','_','_'),
                               List('_','_','_','_','_','_','_','_','_'))
                               
      val tableroPruebas = List(List('A','A','A','A','A','A','A','_','_'),
                               List('_','_','_','_','_','_','_','_','_'),
                               List('_','A','_','A','_','_','_','_','A'),
                               List('_','A','_','A','A','_','_','_','A'),
                               List('_','A','_','_','A','_','_','_','A'),
                               List('_','A','_','_','_','_','_','_','A'),
                               List('_','A','_','_','A','A','_','_','A'),
                               List('_','A','_','A','A','_','_','_','A'),
                               List('_','A','_','A','_','_','_','A','A'))
                               
      val tableroPruebas1=List(List('A','_','_','_','_','_','_','_','A'),
                               List('A','A','_','_','_','_','_','A','A'),
                               List('_','A','A','_','_','_','A','A','_'),
                               List('_','_','A','A','_','A','A','_','_'),
                               List('_','_','_','A','A','A','_','_','_'),
                               List('_','_','_','A','A','A','_','_','_'),
                               List('_','_','A','A','_','A','A','_','_'),
                               List('_','A','A','_','_','_','A','A','_'),
                               List('_','A','_','_','_','_','_','A','_'))
     
     val tableroPruebas2 = List(List('_','_','A','_','_','_','_','_','_'),
                               List('V','_','_','_','_','_','_','_','_'),
                               List('_','_','V','_','_','_','_','_','_'),
                               List('_','_','_','_','_','_','_','_','_'),
                               List('_','_','_','_','_','A','_','_','_'),
                               List('_','_','A','_','_','_','A','_','_'),
                               List('_','V','_','_','A','_','_','_','_'),
                               List('_','_','_','_','_','_','_','_','_'),
                               List('V','_','A','_','_','_','_','_','A'))
                               
     val tableroPruebas3 =List(List('_','_','_','_','_','R','_','_','_'),
                               List('_','_','A','_','_','R','_','_','_'),
                               List('_','_','A','_','_','R','_','_','_'),
                               List('_','_','_','_','_','R','_','_','_'),
                               List('_','_','A','_','_','_','_','_','_'),
                               List('_','_','A','_','_','R','R','R','R'),
                               List('_','_','A','_','_','_','_','_','_'),
                               List('_','_','_','R','_','_','_','_','_'),
                               List('_','_','_','_','_','_','_','_','_'))
                
     val lista = mejor_jugada(tableroPruebas3)
     val fila = lista(0).toInt
     val columna = lista(1).toInt
     val letra = lista(2)
     val contador = lista(3).toInt
     val tipo = lista(4).toInt

     println("Fila:"+ fila)
     println("Columna:"+columna)
     println("Color:"+letra)
     println("Tipo:"+tipo)
     println("ValorContador:"+contador)
     
     
     val listaValores = maximo_lista(List(3,9,4,6,7,3))
     println("Maximo: "+ listaValores(0))
     println("Posicion: "+ listaValores(1))
     
     val tablero_inicial = llenar_tablero_inicial(tablero_vacio,0)
     mostrar_tablero(tablero_inicial)
     escoger_bola(tablero_inicial,0)
     
     //IDEA OPTIMIZACION, IR PROBANDO EN CADA CASILLA VACIA LAS DIFERENTES POSIBILIDADES
     //Y GUARDAR LA MEJOR EN UNA LISTA CON SU CONTADOR, FILA, COLUMNA Y COLOR
  }
}