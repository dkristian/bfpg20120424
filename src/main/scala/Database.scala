trait Id
object Assumed {
  trait Task { def id:Id; def noteId:Id }
  trait Note { def id:Id; def content:String }

  object Database {
    def loadTask(taskId:Id):Option[Task] = {
      // ensure that user is logged in
      sys.error("impl details")
    }
    def loadNote(noteId:Id):Option[Note] = sys.error("impl details")
    def updateNote(noteId:Id, newContent:String) = {
      // ensure that user is logged in
      // make sure note exists
      // check that note belongs to the logged in user
      sys.error("impl details")
    }
  }
}

object TypeChecked {
  sealed trait AuthenticatedUser { def user:User }
  sealed trait Ref[A] { def id:Id }
  sealed trait Task extends Ref[Task] { def note:Ref[Note] }
  sealed trait Note extends Ref[Note] { def content:String }

  class Database(au:AuthenticatedUser) {
    def loadTask(taskId:Id):Option[Task] = {
      // can't call unless user has been authenticated
      sys.error("impl details")
    }
    def loadNote(noteId:Id):Option[Ref[Note]] = sys.error("impl details")
    def updateNote(noteRef:Ref[Note], newContent:String) = {
      // again, can't call unless user has been authenticated
      // can only get noteRef from Database, so know it belongs to auth'ed user
      sys.error("impl details")
    }
  }
}
