package Sample

object Fourier{
  var N = 8
def fiu(acc:Complex,list: List[Complex]): Complex={
  if(list.isEmpty)
    acc
  else
    fiu(acc*list.head,list.tail)
}

  def fastFourierTime(array: Array[Complex]): Array[Complex] = {
    def sort(complexes: Array[Complex], acc: (Array[Complex], Array[Complex])): (Array[Complex], Array[Complex]) = {
      complexes match {
        case i if i.isEmpty=> acc
        case i if !i.isEmpty && i.length%2==0 => sort(complexes.tail,(acc._1 ++ Array(complexes.head), acc._2))
        case i if i.length%2==1 => sort(complexes.tail,(acc._1 , acc._2++ Array(complexes.head)))
       }
    }
    val n=array.length
    if (array.length==1) {
      return array
    }
    val c = sort(array, (Array(), Array()))
    val a = fastFourierTime(c._1)
    val b = fastFourierTime(c._2)
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

  def discreteFourier(array: Array[Complex]): Array[Complex] ={
    val N=array.length
    Fourier(array,-1).map(_/N)
  }
  def reverseFourierFFT(array: Array[Complex]): Array[Complex] =reverseFourier(fastFourierTime,array)
  def reverseFourierDFT(array: Array[Complex]): Array[Complex] =reverseFourier(discreteFourier,array)
  def reverseFourier(f: Array[Complex] =>Array[Complex], array: Array[Complex]):Array[Complex]=Fourier(f(array),1)
  def Fourier(array: Array[Complex],c: Int): Array[Complex] = {
    val N=array.length
    val a= for(i<- array.indices;y<-array.indices) yield
      {
        array(y)* new Complex(Math.cos(2*Math.PI*i*y/N),c*Math.sin(2*Math.PI*i*y/N))
      }
    a.toArray.grouped(N).toArray.foldLeft(Array[Complex]())((b,Q)=>b.:+(Q.foldLeft(new Complex(0,0))((b,a)=>b+a/N)))
  }
}
object CorrAndConv
{
  def f(arrayY: Array[Complex])(arrayZ: Array[Complex]):Array[Complex]={
      Fourier.fastFourierTime(arrayZ).zip(Fourier.fastFourierTime(arrayY)).foldLeft(Array[Complex]())((b,t)=> b.:+ (t._1*t._2))
  }

  def _f(arrayY: Array[Complex])(arrayZ: Array[Complex]):Array[Complex]={
    Fourier.fastFourierTime(arrayZ).map(_.conjugate()).zip(Fourier.fastFourierTime(arrayY)).foldLeft(Array[Complex]())((b,t)=> b.:+ (t._1*t._2))
  }
  def Conv(arrayY: Array[Complex],arrayZ: Array[Complex]): Array[Complex] ={
    def function: Array[Complex] => Array[Complex] =f(arrayY)
    Fourier.reverseFourier(function,arrayZ)}
def Corr(arrayY: Array[Complex],arrayZ: Array[Complex]): Array[Complex] ={
  def function: Array[Complex] => Array[Complex] =_f(arrayY)
  Fourier.reverseFourier(function,arrayZ)}
}
