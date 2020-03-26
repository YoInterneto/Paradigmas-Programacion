

object Bolas {
  
  //Se llena el tablero inicialmente vacio aleatoriamente                    
  def llenar_tablero_inicial(tablero:List[List[Char]],cont:Int):List[List[Char]]={
    
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
      if (tablero(posicion1)(posicion2)=='_'){//Si esa posicion no se ha reemplazado
        val tablero_inicial = reemplazar(tablero(posicion1), posicion2, valor) //tablero(posicion1).updated(posicion2, valor)
        val tablero_inicial_final = reemplazar_lista(tablero, posicion1, tablero_inicial)//tablero.updated(posicion1, tablero_inicial)
        llenar_tablero_inicial(tablero_inicial_final,cont+1)//Llamamos a la funcion con contador + 1
        
      }
      else {llenar_tablero_inicial(tablero,cont)}//Si la posicion esta reemplazada volvemos otra vez
      
   }
        
  }
  
  //Comprueba que fila y columna no se pasen de los limites
  def comprobar_limite(x:Int,y:Int):Boolean={
    
    if(x<=8 && x>=0 && y>=0 && y<=8){
      return true
    }
    else{
      println("Se ha pasado de los limites del tablero")
      return false
    }
  }
  
  //Escoge la bola del tablero que quiere mover
  def escoger_bola(tablero:List[List[Char]]){
     
     if(final_partida(tablero, 0, 0)){
       println("Tablero completo, partida finalizada")
     }
     else{
       print("Introduzca la fila de la bola que quiere utilizar(0-8): ")
       val x = scala.io.StdIn.readInt()
       print("Introduzca la columna de la bola que quiere utilizar(0-8): ")
       val y = scala.io.StdIn.readInt()
       
       if(comprobar_limite(x,y)){
       val bola = tablero(x)(y)
         if(bola!='_'){//Si en el hueco hay una bola
           println("Bola escogida:"+ bola)
           mover_bola(tablero,bola,x,y)
         }
         else{
           println("Posicion vacia, vuelva a introducir ")
           escoger_bola(tablero)
         }
       }
       else{
         escoger_bola(tablero)
       }
     }  
  }
  
  //Mueve la bola escogida a la posicion que le introducimos
  def mover_bola(tablero:List[List[Char]],bola:Char,x:Int,y:Int){
    
    print("Introduzca la fila donde la quiere introducir(0-8): ")
    val x2 = scala.io.StdIn.readInt()
    print("Introduzca la columna donde la quiere introducir(0-8): ")
    val y2 = scala.io.StdIn.readInt()
    if(comprobar_limite(x2, y2)){
      val hueco = tablero(x2)(y2)
      if(hueco=='_'){//Si el hueco donde queremos introducir esta vacio
        val tablero_inicial = reemplazar(tablero(x2),y2,bola)//tablero(x2).updated(y2, bola) 
        val tablero_sin_hueco = reemplazar_lista(tablero, x2, tablero_inicial) //tablero.updated(x2, tablero_inicial)
        val tablero_hueco = reemplazar(tablero_sin_hueco(x), y, '_') //tablero_sin_hueco(x).updated(y, '_')//Donde estaba la bola antes, ahora esta vacio
        val tablero_con_hueco = reemplazar_lista(tablero_sin_hueco, x, tablero_hueco)//tablero_sin_hueco.updated(x, tablero_hueco)//Lo reemplazamos
        
        //escoger_bola(tablero_con_hueco)
        val tablero_sig_turno = rellenar_turno(tablero_con_hueco, 0)
        mostrar_tablero(tablero_sig_turno)
        escoger_bola(tablero_sig_turno)
         
      }
      else{
        println("Hueco ocupado, no puede introducir la bola en este hueco")
        mover_bola(tablero,bola,x,y)
      }
    }
    else{
      mover_bola(tablero,bola,x,y)
    }
    
    
  }
  
  //En cada turno se introducen 3 bolas aleatorias
  def rellenar_turno(tablero:List[List[Char]],cont:Int):List[List[Char]]={//Para rellenar las 3 en cada turno

    val huecos = huecos_restantes(tablero, 0, 0, 0)
    val lista = List('A','N','R','V','M','G')
    val r = scala.util.Random
    val color = r.nextInt(6)
    val posicion1 = r.nextInt(9)
    val posicion2 = r.nextInt(9)
    val valor = lista(color)
    
    if(cont==3){
      return tablero
    }
    else{
    //Si queda un hueco lo rellena
      if(huecos==1){
        if(tablero(posicion1)(posicion2)=='_'){//Si esa posicion no se ha reemplazado
          val tablero_inicial = reemplazar(tablero(posicion1), posicion2, valor)//tablero(posicion1).updated(posicion2, valor)
          val tablero_inicial_final = reemplazar_lista(tablero, posicion1, tablero_inicial)//tablero.updated(posicion1, tablero_inicial)
          return tablero_inicial_final//Si solo quedaba un hueco, se completa y devuelve el tablero final
      }
        else {
          rellenar_turno(tablero,cont)
        }
      }
      
      else{
        if(tablero(posicion1)(posicion2)=='_'){//Si esa posicion no se ha reemplazado
          val tablero_inicial = reemplazar(tablero(posicion1), posicion2, valor)//tablero(posicion1).updated(posicion2, valor)
          val tablero_inicial_final = reemplazar_lista(tablero, posicion1, tablero_inicial)//tablero.updated(posicion1, tablero_inicial)
          rellenar_turno(tablero_inicial_final,cont+1)//Llamamos a la funcion con contador +1
      }
        else {
          rellenar_turno(tablero,cont)
        }
      }
        
    }
    
  }
  //Comprueba que se ha terminado la partida (tablero completo)
  def final_partida(tablero:List[List[Char]],fila:Int,columna:Int):Boolean={
    if(fila==9){
      return true
    }
    else{
      if(columna==9){
        final_partida(tablero,fila+1,0)
      }
      else{
        if(tablero(fila)(columna)=='_'){
          return false
      }
        else{
          final_partida(tablero,fila,columna+1)
          
        }
      }
      
    }
  }
  
  //Funcion auxiliar para saber los huecos restantes, se usara en rellenear_turno
  def huecos_restantes(tablero:List[List[Char]],cont:Int,fila:Int,columna:Int): Int={
    if(fila==9){
      return cont
    }
    else{
      if(columna==9){
      huecos_restantes(tablero, cont, fila+1, 0)
    }
    else{
      if(tablero(fila)(columna)=='_'){
        huecos_restantes(tablero, cont+1, fila,columna+1)
      }
      else{
        huecos_restantes(tablero, cont, fila,columna+1)
      }
    }
    }
    
  }
  
  
  //Mostrar el tablero bien, asi es un poco guarro
  def mostrar_tablero(tablero:List[List[Char]]):List[List[Char]]={
    
    println(tablero(0))
    println(tablero(1))
    println(tablero(2))
    println(tablero(3))
    println(tablero(4))
    println(tablero(5))
    println(tablero(6))
    println(tablero(7))
    println(tablero(8))
    return tablero
  }
  
  //Funcion que cuenta los huecos libres que hay en el tablero
  /*def huecos_libres(tablero: List[List[Char]], huecos: Int, indexFila: Int): Int = {
    if(indexFila == 0){
      val ocurrencias = tablero(indexFila).count(x => {x == '_'})
      huecos + ocurrencias
    }else{
      val ocurrencias = tablero(indexFila).count(x => {x == '_'})
      huecos_libres(tablero, huecos + ocurrencias, indexFila - 1)
    }
  }*/
  
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
  def comprobar_tablero(tablero:List[List[Char]],fila:Int,columna:Int):List[List[Char]] = {
    //Si llegamos al final de una fila vamos a la siguiente
    println("("+ fila +" x "+ columna+")")
    if(columna == 9){
      comprobar_tablero(tablero, fila + 1, 0)
    }
    //Si llegamos al final retornamos el tablero
    else if(fila == 9){
      tablero
    }
    //Para las demas posiciones, comprobamos su horizontal, vertical y diagonales
    else{
      val horizontal_cont = horizontal(tablero, 1, fila, columna)
      val vertical_cont = vertical(tablero, 1, fila, columna)
      val diagonalIzq_cont = diagonalIzq(tablero, 1, fila, columna)
      val diagonalDcha_cont = diagonalDcha(tablero, 1, fila, columna)
      
      //Si para esa posicion no se ha encontrado nada, se sigue iterando igual
      if((horizontal_cont < 5) && (vertical_cont < 5) && 
          (diagonalIzq_cont < 5) && (diagonalDcha_cont < 5)){
        comprobar_tablero(tablero, fila, columna+1)
      //Si se encuentra una coincidencia se borran las fichas del tablero y se
      //sigue iterando con el mismo tablero
      }else{
        if(horizontal_cont >= 5){
          val tableroAux = borrar_horizontal(tablero, horizontal_cont, fila, columna) //Tablero borrando columna + horizontal_cont posiciones
          mostrar_tablero(tableroAux)
          println("********************************\n")
          comprobar_tablero(tableroAux, fila, columna+1)
        }else if(vertical_cont >= 5){
          val tableroAux = borrar_vertical(tablero, vertical_cont, fila, columna) //Tablero borrando fila + vertical_cont posiciones
          mostrar_tablero(tableroAux)
          println("********************************\n")
          comprobar_tablero(tableroAux, fila, columna+1)
        }else if(diagonalIzq_cont >= 5){
          val tableroAux = List() //Tablero borrando la diagonalIzq
          comprobar_tablero(tableroAux, fila, columna+1)
        }else{
          val tableroAux = List() //Tablero borrando la diagonalDcha
          comprobar_tablero(tableroAux, fila, columna+1)
        }
      }
    }
  }
  
  
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
  
  def borrar_horizontal(tablero: List[List[Char]], contador: Int, fila: Int, columna: Int):List[List[Char]] = {
    if(contador == 0){
      //boramos una ultima vez y devolvemos el tablero
      val lineaTablero = tablero(fila)
      val lineaTableroAux = reemplazar(lineaTablero, columna, '_')
      val tableroAux = reemplazar_lista(tablero, fila, lineaTableroAux)
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
  
  def borrar_vertical(tablero: List[List[Char]], contador: Int, fila: Int, columna: Int):List[List[Char]] = {
    if(contador == 0){
      //boramos una ultima vez y devolvemos el tablero
      val lineaTablero = tablero(fila)
      val lineaTableroAux = reemplazar(lineaTablero, columna, '_')
      val tableroAux = reemplazar_lista(tablero, fila, lineaTableroAux)
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
  
  def diagonalDcha(tablero: List[List[Char]], contador: Int, fila: Int, columna: Int):Int = {
    contador
  }
  
  def diagonalIzq(tablero: List[List[Char]], contador: Int, fila: Int, columna: Int):Int = {
    contador
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
                               List('_','A','_','_','_','_','_','_','_'),
                               List('_','A','_','_','_','_','_','_','_'),
                               List('_','A','_','_','_','_','_','_','_'),
                               List('_','a','_','_','_','_','_','_','_'),
                               List('_','a','_','_','_','_','_','_','_'),
                               List('_','a','_','_','_','_','_','_','_'),
                               List('_','a','_','_','_','_','_','_','_'))
                               
                               
      println("****primera fila****")
      val nuevo = borrar_horizontal(tableroPruebas, 5, 0, 0)
      mostrar_tablero(nuevo)
      println("****segunda fila****")

      val nuevo2 = borrar_vertical(tableroPruebas, 7, 2, 1)
      mostrar_tablero(nuevo2)
      println("****segunda/2 fila****")

      val nuevo3 = borrar_vertical(tableroPruebas, 3, 2, 1)
      mostrar_tablero(nuevo3)
      println("******************************")
      
      comprobar_tablero(tableroPruebas, 0, 0)

                 
      //No sabia que esta funcion estaba hecha jj, era tambien para ir aprendiendo el lenguaje
      //y viendo cosas, si se puede utilizar el count, es mejor que la que esta
      //val huecos = huecos_libres(tablero_vacio, 0, 8)
      //println(huecos)
    
    //val lista = List(1,2,3,4,5)
    
    //println(reemplazar(List('A','B','C','D','E'), 2, 'A'))
    //println(reemplazar_lista(tablero_vacio, 0, List('A','B','C','D','E')))
    
                               
     //val tablero_inicial = llenar_tablero_inicial(tablero_vacio,0)//Llenamos el tablero
     //mostrar_tablero(tablero_inicial)
     //escoger_bola(tablero_inicial)
     //FALTA COMPROBAR LAS 5 EN LINEA, ELIMINARLAS Y PUNTUACION
     
   


    
  }
}