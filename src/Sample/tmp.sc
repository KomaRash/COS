import Sample.Complex

def sort(array: Array[Complex], acc: (Array[Complex], Array[Complex])): (Array[Complex], Array[Complex]) = {
/* array match {
    case i if i.length == 0 => acc
    case i if i.length == 2 => (acc._1 ++ Array(array.head), acc._2 ++ Array(array.tail.head))
    case _ =>
  }
  */
}
sort(Array(new Complex(0,0),new Complex(1,0),new Complex(0,0),new Complex(0,0)),(Array[Complex](),Array[Complex]()))