case class User(pwdHash:PasswordHash)
trait SessionToken
trait Password
trait PasswordHash {
  def matches(other:PasswordHash) =
    sys.error("Impl details"):Boolean
}
object Password {
  def hash(pwd:NonEmptyString) =
    sys.error("Impl details"):PasswordHash
}
sealed trait AuthenticatedUser { def user:User }
object Authentication {
  // Impl details aren't important; what's important to note is that the only way
  // to get an AuthenticatedUser instance is with these methods
  def authenticate(usr:User, pwd:NonEmptyString):Option[AuthenticatedUser] =
    if (Password.hash(pwd).matches(usr.pwdHash))
      Some(new AuthenticatedUser { val user = usr })
    else
      None

  def authenticate(usr:User, tok:SessionToken):Option[AuthenticatedUser] =
    sys.error("impl details")
}
