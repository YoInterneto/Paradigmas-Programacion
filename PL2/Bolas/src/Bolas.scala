

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
          val diagonal1Dcha_cont = diagonal1Dcha(tablero, 1, fila, columna)
          val diagonal1Izq_cont = diagonal1Izq(tablero, 1, fila, columna)
          
          if((horizontal_cont < 5) && (vertical_cont < 5) && 
            (diagonal1Izq_cont < 5) && (diagonal1Dcha_cont < 5)){
            
            calcular_puntuacion(tablero, puntuacion, fila, columna+1)
            
          }else{
            if(horizontal_cont >= 5){
              val tableroAux = borrar_horizontal(tablero, horizontal_cont, fila, columna) 
              calcular_puntuacion(tableroAux, puntuacion + horizontal_cont, fila, columna+1)
              
            }else if(vertical_cont >= 5){
              val tableroAux = borrar_vertical(tablero, vertical_cont, fila, columna)
              calcular_puntuacion(tableroAux, puntuacion + vertical_cont, fila, columna+1)
              
            }else if(diagonal1Izq_cont >= 5){
              val tableroAux = List()
              calcular_puntuacion(tablero, puntuacion, fila, columna+1)
            }else{
              val tableroAux = List()
              calcular_puntuacion(tablero, puntuacion, fila, columna+1)
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
        val diagonal2Izq_cont = diagonal1Izq(tablero, 1, fila, columna)
        val diagonal2Dcha_cont = diagonal1Dcha(tablero, 1, fila, columna)
        
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
  
  
  //itera con fila+1 columna+1
  //si es la primera vuelta -> 
  def diagonal1Dcha(tablero: List[List[Char]], contador: Int, fila: Int, columna: Int):Int = {
    if(fila == 8 || columna == 8){
      contador
    }else{
      val diagonalPrincipal = diagonal(tablero, 1, fila, columna, 'd')
      val diagonalSecundaria = diagonal(tablero, 1, fila+1, columna, 'd')
      
      //Caso en el que la diagonalPrincipal es mas grande 
      if((diagonalPrincipal > diagonalSecundaria) && (diagonalSecundaria > 1)){
           ((diagonalSecundaria + 1) + diagonalSecundaria)
      //Caso diagonalSecundaria mas grande o igual
      }else if((diagonalPrincipal <= diagonalSecundaria) && (diagonalSecundaria > 1)){
           ((diagonalPrincipal - 1) + diagonalPrincipal)
      }else{
        contador
      }
    }
  }
  
  
  def diagonal2Dcha(tablero: List[List[Char]], contador: Int, fila: Int, columna: Int):Int = {
    if(fila == 8 || columna == 8){
      contador
    }else{
      val diagonalPrincipal = diagonal(tablero, 1, fila, columna, 'd')
      val diagonalSecundaria = diagonal(tablero, 1, fila, columna+1, 'd')
      
      //Caso en el que la diagonalPrincipal es mas grande 
      if((diagonalPrincipal > diagonalSecundaria) && (diagonalSecundaria > 1)){
         ((diagonalSecundaria + 1) + diagonalSecundaria)
      //Caso diagonalSecundaria mas grande o igual
      }else if((diagonalPrincipal <= diagonalSecundaria) && (diagonalSecundaria > 1)){
          ((diagonalPrincipal - 1) + diagonalPrincipal)
      }else{
        contador
      }
    }
  }
  
  //itera con fila+1 columna-1
  def diagonal1Izq(tablero: List[List[Char]], contador: Int, fila: Int, columna: Int):Int = {
    if(fila == 8 || columna == 8){
      contador
    }else{
      val diagonalPrincipal = diagonal(tablero, 1, fila, columna, 'i')
      val diagonalSecundaria = diagonal(tablero, 1, fila+1, columna, 'i')
      
      //Caso en el que la diagonalPrincipal es mas grande 
      if((diagonalPrincipal > diagonalSecundaria) && (diagonalSecundaria > 1)){
         ((diagonalSecundaria + 1) + diagonalSecundaria)
      //Caso diagonalSecundaria mas grande o igual
      }else if((diagonalPrincipal <= diagonalSecundaria) && (diagonalSecundaria > 1)){
          ((diagonalPrincipal - 1) + diagonalPrincipal)
      }else{
        contador
      }
    }
  }
  
  
  def diagonal2Izq(tablero: List[List[Char]], contador: Int, fila: Int, columna: Int):Int = {
    if(fila == 8 || columna == 8){
      contador
    }else{
      val diagonalPrincipal = diagonal(tablero, 1, fila, columna, 'i')
      val diagonalSecundaria = diagonal(tablero, 1, fila, columna-1, 'i')
      
      //Caso en el que la diagonalPrincipal es mas grande 
      if((diagonalPrincipal > diagonalSecundaria) && (diagonalSecundaria > 1)){
         ((diagonalSecundaria + 1) + diagonalSecundaria)
      //Caso diagonalSecundaria mas grande o igual
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
  def diagonal(tablero: List[List[Char]], contador: Int, fila: Int, columna: Int, lado: Char):Int = {
    if(fila == 8 || columna == 8){
      contador
    }else{
      if(tablero(fila)(columna) != '_'){
        if(lado == 'i'){
          if(columna != 0){
            if(tablero(fila)(columna) == tablero(fila+1)(columna-1)){
            diagonal(tablero, contador+1, fila+1, columna-1, lado)
            }else{
              contador
            }
          }
          else{
            contador
          }
          
        }else if(lado == 'd'){
          if(tablero(fila)(columna) == tablero(fila+1)(columna+1)){
            diagonal(tablero, contador+1, fila+1, columna+1, lado)
          }else{
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
  
  
  def contador_puntuacion(contador:Int):Int={
    val puntuacion = contador*75
    puntuacion
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
                               
      val tableroPruebas = List(List('A','A','A','A','A','_','A','_','_'),
                               List('_','_','_','_','_','_','_','_','_'),
                               List('_','A','_','A','_','_','_','_','A'),
                               List('_','A','_','A','A','_','_','_','A'),
                               List('_','A','_','_','A','A','_','_','A'),
                               List('_','A','_','_','_','_','_','_','A'),
                               List('_','A','_','_','_','A','_','_','A'),
                               List('_','A','_','_','A','A','_','_','A'),
                               List('_','A','_','A','A','_','_','_','A'))
      
      comprobar_tablero(tableroPruebas)
      /*println("****primera fila****")
      val nuevo = borrar_horizontal(tableroPruebas, 5, 0, 0)
      mostrar_tablero(nuevo)
      println("****segunda fila****")

      val nuevo2 = borrar_vertical(tableroPruebas, 7, 2, 1)
      mostrar_tablero(nuevo2)
      println("****segunda/2 fila****")

      val nuevo3 = borrar_vertical(tableroPruebas, 3, 2, 1)
      mostrar_tablero(nuevo3)
      println("******************************")*/
      
      //comprobar_tablero(tableroPruebas)
                 
      //No sabia que esta funcion estaba hecha jj, era tambien para ir aprendiendo el lenguaje
      //y viendo cosas, si se puede utilizar el count, es mejor que la que esta
      //val huecos = huecos_libres(tablero_vacio, 0, 8)
      //println(huecos)
    
    //val lista = List(1,2,3,4,5)
    
    //println(reemplazar(List('A','B','C','D','E'), 2, 'A'))
    //println(reemplazar_lista(tablero_vacio, 0, List('A','B','C','D','E')))
        
        //println(calcular_puntuacion(tableroPruebas, 0, 0, 0))
     //val tablero_inicial = llenar_tablero_inicial(tablero_vacio,0)//Llenamos el tablero
     //mostrar_tablero(tablero_inicial)
     //escoger_bola(tablero_inicial,0)
     //FALTA COMPROBAR LAS 5 EN LINEA, ELIMINARLAS Y PUNTUACION
     
   


    
  }
}