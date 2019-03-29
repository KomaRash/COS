package Sample

class Complex(val re:Double,val im:Double) {
  override def toString = {
    re + (if (im < 0) "-" + -im else "+" + im) + "*i"
  }
  def +(c: Complex) = new Complex(re + c.re, im + c.im)
  def -(c: Complex) = new Complex(re - c.re, im - c.im)
  def mod()=Math.sqrt(re*re + im*im)
  def *(c:Complex)=new Complex(re*c.re-im*c.im,re*c.im+im*c.re)
  def /(c:Double)=new Complex(re/c,im/c)
  def phase(): Double =Math.atan(im/re)
  def conjugate():Complex=new Complex(re,im*(-1))

}