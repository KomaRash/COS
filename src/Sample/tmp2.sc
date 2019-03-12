import Sample.Complex
val array=Array(0,5,9,5,4,2,3,5,84,2,0)
val N = array.length
val  a=for(x<-array;i <-0 to array.length) yield {
  x * 2*i
}

def discreteFourier(array: Array[Complex]): Array[Complex] = {
  val N=array.length
  val a= for(y<-0 to array.length-1;i<- 0 to array.length-1) yield
    {
      array(y)* new Complex(Math.cos(2*Math.PI*i*y/N),Math.sin(2*Math.PI*i*y/N))
    }
  a.toArray.grouped(N).toArray.foldLeft(Array[Complex]())((b,Q)=>b.:+(Q.foldLeft(new Complex(0,0))((b,a)=>b+a)))
}
discreteFourier(Array(new Complex(5,5),new Complex(3,5)))