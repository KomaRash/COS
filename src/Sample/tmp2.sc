import Sample.Complex
val array=Array(0,1,2,3,4,5)
val N = array.length
val  a=for(y <-array.indices;i <-array.indices) yield {
  array(y) *i
}

def discreteFourier(array: Array[Complex]): Array[Complex] = {
  val N=array.length
  val a= for(y<-array.indices; i<- array.indices) yield
    {
      array(y)* new Complex(Math.cos(2*Math.PI*i*y/N),-1*Math.sin(2*Math.PI*i*y/N))
    }
  a.toArray.grouped(N).toArray.foldLeft(Array[Complex]())((b,Q)=>b.:+(Q.foldLeft(new Complex(0,0))((b,a)=>b+a/N)))
}
def FFF(array: Array[Complex], n: Int): Array[Complex] = {
  def sort(complexes: Array[Complex], acc: (Array[Complex], Array[Complex])): (Array[Complex], Array[Complex]) = {
    complexes match {
      case i if i.isEmpty=> acc
      case i if !i.isEmpty && i.length%2==0 => sort(complexes.tail,(acc._1 ++ Array(complexes.head), acc._2))
      case i if i.length%2==1 => sort(complexes.tail,(acc._1 , acc._2++ Array(complexes.head)))
    }
  }
  if (array.length==1) {
    return array
  }
  val c = sort(array, (Array(), Array()))
  val a = FFF(c._1, n / 2)
  val b = FFF(c._2, n / 2)
  val wn = new Complex(Math.cos(Math.PI * 2 /n ), -1*Math.sin(Math.PI * 2 / n))
  val w = new Complex(1, 0)

  def f(acc: (Array[Complex], Array[Complex]), a: Array[Complex], b: Array[Complex], w: Complex): (Array[Complex], Array[Complex])
  = {
    if (a.isEmpty)
      acc
    else
      f((acc._1 ++ Array(a.head + b.head * w), acc._2 ++ Array(a.head - b.head * w)), a.tail, b.tail, w * wn)
  }
  val y = f((Array(), Array()), a, b, w)
  (y._1 ++ y._2)
}
FFF(Array(new Complex(5,5),new Complex(3,5)),2)
discreteFourier(Array(new Complex(5,5),new Complex(3,5)))