package storage

package object model {
  type Name = Option[String]
  type Description = Option[String]
  type Value = Any
  type PathStr = String
  type AnySimpleElement = SimpleElement[Value]
  type AnyElement = StorageElement[Value]
  type AnyElements = Map[PathStr, AnyElement]
  type ReprElements = Map[PathStr, ReprElement]

  object PathOpt {

  }
}
