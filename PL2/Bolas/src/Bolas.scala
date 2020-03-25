

object Bolas {
  
                      
  def llenar_tablero_inicial(tablero:List[List[Char]],cont:Int):List[List[Char]]={
    
    val lista = List('A','N','R','V','M','G')
    
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
        val tablero_inicial = tablero(posicion1).updated(posicion2, valor)
        val tablero_inicial_final = tablero.updated(posicion1, tablero_inicial)
        llenar_tablero_inicial(tablero_inicial_final,cont+1)//Llamamos a la funcion con contador +1
        
      }
      else {llenar_tablero_inicial(tablero,cont)}//Si la posicion esta reemplazada volvemos otra vez
      
   }
        
  }
  
  def comprobar_limite(x:Int,y:Int):Boolean={
    
    if(x<=8 && x>=0 && y>=0 && y<=8){
      return true
    }
    else{
      println("Se ha pasado de los limites del tablero")
      return false
    }
  }
  
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
         if(bola!='_'){
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
  
  def mover_bola(tablero:List[List[Char]],bola:Char,x:Int,y:Int){
    
    print("Introduzca la fila donde la quiere introducir(0-8): ")
    val x2 = scala.io.StdIn.readInt()
    print("Introduzca la columna donde la quiere introducir(0-8): ")
    val y2 = scala.io.StdIn.readInt()
    if(comprobar_limite(x2, y2)){
      val hueco = tablero(x2)(y2)
      if(hueco=='_'){
        val tablero_inicial = tablero(x2).updated(y2, bola)
        val tablero_sin_hueco = tablero.updated(x2, tablero_inicial)
        val tablero_hueco = tablero_sin_hueco(x).updated(y, '_')
        val tablero_con_hueco = tablero_sin_hueco.updated(x, tablero_hueco)
        
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
          val tablero_inicial = tablero(posicion1).updated(posicion2, valor)
          val tablero_inicial_final = tablero.updated(posicion1, tablero_inicial)
          return tablero_inicial_final//Llamamos a la funcion con contador +1
      }
        else {
          rellenar_turno(tablero,cont)
        }
      }
      
      else{
        if(tablero(posicion1)(posicion2)=='_'){//Si esa posicion no se ha reemplazado
          val tablero_inicial = tablero(posicion1).updated(posicion2, valor)
          val tablero_inicial_final = tablero.updated(posicion1, tablero_inicial)
          rellenar_turno(tablero_inicial_final,cont+1)//Llamamos a la funcion con contador +1
      }
        else {
          rellenar_turno(tablero,cont)
        }
      }
        
    }
    
  }
  //Falta controlar cuando al final quedan 2 o 1 hueco poque se raya al reemplazar las 3 
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
  
  

  def mostrar_tablero(tablero:List[List[Char]]):List[List[Char]]={//Mostrar el tablero bien
    
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
                      
  def main(args: Array[String]){
      val tablero_vacio = List(List('A','A','A','A','A','A','A','A','A'),
                      List('N','G','R','A','A','A','A','A','A'),
                      List('A','N','A','_','G','G','A','G','G'),
                      List('A','R','A','A','R','A','A','G','A'),
                      List('_','_','G','G','G','G','A','_','A'),
                      List('A','_','_','G','G','G','A','_','A'),
                      List('A','_','G','_','G','_','_','_','_'),
                      List('A','_','A','A','A','_','A','A','A'),
                      List('A','A','G','G','G','G','A','A','A'))

    val tablero_inicial=llenar_tablero_inicial(tablero_vacio,0)
    mostrar_tablero(tablero_inicial)
    escoger_bola(tablero_inicial)
    //FALTA COMPROBAR LAS 5 EN LINEA, ELIMINARLAS Y PUNTUACION

   


    
  }
}