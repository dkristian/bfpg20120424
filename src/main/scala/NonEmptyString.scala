sealed trait NonEmptyString {
  def value:String
  def head:Char = value.head
}
object NonEmptyString {
  def nonEmptyString(str:String):Option[NonEmptyString] =
    if (str.isEmpty) None else Some(new NonEmptyString { val value = str})

  def nonEmptyString(head:Char,tail:String):NonEmptyString =
    new NonEmptyString { val value = head + tail }
}
