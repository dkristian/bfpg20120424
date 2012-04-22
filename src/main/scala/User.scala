object FirstTry {
  case class User(fName:String, lName:String)
  def initials(u:User):(Char,Char) =
    (u.fName.head, u.lName.head)

  val bruce = User("Bruce","Wayne")
  val batman = User("Batman", "")
  def run() = {
    println(initials(bruce))
    println(initials(batman))
  }
}

object TryAgain {
  type Name = NonEmptyString

  case class User(fName:Name, lName:Name)
  def initials(u:User):(Char,Char) =
    (u.fName.head, u.lName.head)

  object User {
    import NonEmptyString.nonEmptyString
    def create(fName:String,lName:String):Option[User] =
      for {fn <- nonEmptyString(fName)
           ln <- nonEmptyString(lName)
      } yield User(fn,ln)
  }

  val bruce = User.create("Bruce","Wayne")
  val batman = User.create("Batman","")
  def run() = {
    println(bruce.map(initials))
    println(batman.map(initials))
  }
}
