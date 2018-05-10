package storage

trait StorageLike extends Printable { self =>
  def repr: Repr

  def apply(path: Path): AnyElement

  def apply(path: PathStr): AnyElement = apply(Path(path))

  def getBoolean(path: Path): Boolean

  def getInt(path: Path): Int

  def getString(path: Path): String

  def getDecimal(path: Path): BigDecimal

  def getElement(path: Path): AnyElement

  def getComplexElement(path: Path): ComplexElement

  def getObjectElement(path: Path): ObjectElement

  def getArrayElement(path: Path): ArrayElement

  def getArrayElement(path: PathStr): ArrayElement = getArrayElement(Path(path))

  def getDataElement(path: Path): DataElement

  def getData(paths: Paths): Data

  def updateElement(path: Path, definition: AnyElement, consistency: Consistency): StorageLike

  def updateDataElement(x: DataElement): StorageLike

  def updateData(x: Data): StorageLike

  def addElement(path: Path, definition: AnyElement): StorageLike

  def getBoolean(path: PathStr): Boolean = getBoolean(Path(path))

  def getInt(path: PathStr): Int = getInt(Path(path))

  def getString(path: PathStr): String = getString(Path(path))

  def getDecimal(path: PathStr): BigDecimal = getDecimal(Path(path))

  def getElement(path: PathStr): AnyElement = getElement(Path(path))

  def getDataElement(path: PathStr): DataElement = getDataElement(Path(path))

  def getData(paths: List[PathStr]): Data = getData(Paths.fromPathStrs(paths))

  def updateData(x: (PathStr, Value)*): StorageLike = x match {
    case Seq() => self
    case Seq((path, value)) => updateDataElement(DataElement(path, value))
    case Seq(a, as @ _*) => updateData(Data(x.toMap))
  }

  def addDataElement(x: DataElement): StorageLike

  def addData(x: Data): StorageLike

  def addData(x: (PathStr, Value)*): StorageLike = x match {
    case Seq() => self
    case Seq((path, value)) => addDataElement(DataElement(path, value))
    case Seq(a, as @ _*) => addData(Data(x.toMap))
  }

  def updateElement(path: PathStr, definition: AnyElement, consistency: Consistency = Consistency.Strict): StorageLike = updateElement(Path(path), definition, consistency)

  def addElement(path: PathStr, definition: AnyElement): StorageLike = addElement(Path(path), definition)

  def addElement(definition: AnyElement): StorageLike
}