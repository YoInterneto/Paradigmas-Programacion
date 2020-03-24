

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
  
  def mover_bola(tablero:List[List[Char]]):List[List[Char]]={
     
     print("Introduzca la fila de la bola que quiere utilizar(0-8)=: ")
     val x = scala.io.StdIn.readInt()
     print("Introduzca la columna de la bola que quiere utilizar(0-8): ")
     val y = scala.io.StdIn.readInt()
     val bola = tablero(x)(y)
     if(bola!='_'){
       //Aqui esta la chicha
     }
     else{
       println("Posicion vacia, vuelva a introducir ")
       mover_bola(tablero)
     }
     return tablero
  }

  def mostrar_tablero(tablero:List[List[Char]]):List[List[Char]]={//Mostrar el tablero bien
    val tablero_final=llenar_tablero_inicial(tablero,0)
    println(tablero_final(0))
    println(tablero_final(1))
    println(tablero_final(2))
    println(tablero_final(3))
    println(tablero_final(4))
    println(tablero_final(5))
    println(tablero_final(6))
    println(tablero_final(7))
    println(tablero_final(8))
    return tablero_final
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

    
    mover_bola(mostrar_tablero(tablero_vacio))

   


    
  }
}