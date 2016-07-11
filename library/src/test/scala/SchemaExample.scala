package sbt.datatype

import java.io.File

object SchemaExample {
  val basicSchema = """{
  "namespace": "com.example",
  "protocol": "HelloWorld",
  "doc": "Protocol Greetings",

  "types": [
    {"name": "Greeting", "type": "record", "fields": [
      {"name": "message", "type": "string"}]}
  ]
}"""

  val growableSchema = """{
  "namespace": "com.example",
  "protocol": "HelloWorld",
  "doc": "Protocol Greetings",

  "types": [
    {"name": "Greeting", "type": "record", "fields": [
      {"name": "message", "type": "string", "since": "0.1.0"},
      {"name": "name", "type": "string", "since": "0.2.0", "default": "foo" }]}
  ]
}"""

}

object NewSchema {

  val emptySchemaExample = """{}"""

  val emptyInterfaceExample = """{
  "type": "interface",
  "target": "Scala",
  "name": "emptyInterfaceExample"
}"""

  val emptyRecordExample = """{
  "type": "record",
  "target": "Scala",
  "name": "emptyRecordExample"
}"""

  val emptyEnumerationExample = """{
  "type": "enumeration",
  "target": "Scala",
  "name": "emptyEnumerationExample"
}"""

  val invalidDefinitionKindExample = """{
  "type": "invalid",
  "name": "hello"
}"""

  val simpleInterfaceExample = """{
  "type": "interface",
  "doc": "example of simple interface",
  "name": "simpleInterfaceExample",
  "target": "Scala",
  "fields": [
    {
      "name": "field",
      "type": "type"
    }
  ]
}"""

  val oneChildInterfaceExample = """{
  "name": "oneChildInterfaceExample",
  "type": "interface",
  "target": "Scala",
  "doc": "example of interface",
  "types": [
    {
      "name": "childRecord",
      "type": "record",
      "target": "Scala"
    }
  ]
}"""

  val nestedInterfaceExample = """{
  "name": "nestedProtocolExample",
  "target": "Scala",
  "type": "interface",
  "doc": "example of nested protocols",
  "types": [
    {
      "name": "nestedProtocol",
      "target": "Scala",
      "type": "interface"
    }
  ]
}"""

  val simpleRecordExample = """{
  "name": "simpleRecordExample",
  "type": "record",
  "target": "Scala",
  "doc": "Example of simple record",
  "fields": [
    {
      "name": "field",
      "type": "java.net.URL"
    }
  ]
}"""

  val simpleEnumerationExample = """{
  "name": "simpleEnumerationExample",
  "target": "Scala",
  "type": "enumeration",
  "doc": "Example of simple enumeration",
  "types": [
    {
      "name": "first",
      "doc": "First type"
    },
    "second"
  ]
}"""

  val fieldExample = """{
  "name": "fieldExample",
  "doc": "Example of field",
  "type": "type",
  "since": "1.0.0",
  "default": "2 + 2"
}"""

  val abstractMethodExample = """{
  "name": "abstractMethodExample",
  "doc": "Example of abstract method",
  "type": "type",
  "args": [
    {
      "name": "arg0",
      "type": "type2"
    }
  ]
}"""

  val simpleTpeRefExample = "simpleTpeRefExample"
  val lazyTpeRefExample = "lazy lazyTpeRefExample"
  val arrayTpeRefExample = "arrayTpeRefExample*"
  val optionTpeRefExample = "optionTpeRefExample?"
  val lazyArrayTpeRefExample = "lazy lazyArrayTpeRefExample*"
  val lazyOptionTpeRefExample = "lazy lazyOptionTpeRefExample?"

  val primitiveTypesExample = """{
  "types": [
    {
      "name": "primitiveTypesExample",
      "target": "Scala",
      "type": "record",
      "fields": [
        {
          "name": "simpleInteger",
          "type": "int"
        },
        {
          "name": "lazyInteger",
          "type": "lazy int"
        },
        {
          "name": "arrayInteger",
          "type": "int*"
        },
        {
          "name": "optionInteger",
          "type": "int?"
        },
        {
          "name": "lazyArrayInteger",
          "type": "lazy int*"
        },
        {
          "name": "lazyOptionInteger",
          "type": "lazy int?"
        }
      ]
    }
  ]
}"""

  val primitiveTypesNoLazyExample = """{
  "types": [
    {
      "name": "primitiveTypesNoLazyExample",
      "target": "Scala",
      "type": "record",
      "fields": [
        {
          "name": "simpleInteger",
          "type": "int"
        },
        {
          "name": "arrayInteger",
          "type": "int*"
        }
      ]
    }
  ]
}"""

  val generateArgDocExample = """{
  "codecNamespace": "generated",
  "types": [
    {
      "name": "generateArgDocExample",
      "target": "Scala",
      "type": "interface",
      "fields": [
        {
          "name": "field",
          "type": "int",
          "doc": "I'm a field."
        }
      ],
      "methods": [
        {
          "name": "methodExample",
          "doc": [
            "A very simple example of abstract method.",
            "Abstract methods can only appear in interface definitions."
          ],
          "type": "int*",
          "args": [
            {
              "name": "arg0",
              "type": "lazy int*",
              "doc": [
                "The first argument of the method.",
                "Make sure it is awesome."
              ]
            },
            {
              "name": "arg1",
              "type": "boolean",
              "doc": "This argument is not important, so it gets single line doc."
            }
          ]
        }
      ]
    }
  ]
}"""

  val completeExample = """{
  "codecNamespace": "generated",
  "fullCodec": "CustomProtcol",
  "types": [
    {
      "name": "Greetings",
      "namespace": "com.example",
      "target": "Scala",
      "doc": "A greeting interface",
      "type": "interface",

      "fields": [
        {
          "name": "message",
          "doc": [
            "The message of the Greeting",
            "This is a multiline doc comment"
          ],
          "type": "lazy String"
        },
        {
          "name": "header",
          "doc": "The header of the Greeting",
          "type": "com.example.GreetingHeader",
          "default": "new com.example.GreetingHeader(new java.util.Date(), \"Unknown\")",
          "since": "0.2.0"
        }
      ],

      "types": [
        {
          "name": "SimpleGreeting",
          "namespace": "com.example",
          "target": "Scala",
          "type": "record",
          "doc": "A Greeting in its simplest form"
        },
        {
          "name": "GreetingWithAttachments",
          "namespace": "com.example",
          "target": "Scala",
          "type": "record",
          "doc": "A Greeting with attachments",

          "fields": [
            {
              "name": "attachments",
              "type": "java.io.File*",
              "doc": "The files attached to the greeting"
            }
          ]
        }
      ]
    },
    {
      "name": "GreetingHeader",
      "namespace": "com.example",
      "target": "Scala",
      "type": "record",
      "doc": "Meta information of a Greeting",

      "fields": [
        {
          "name": "created",
          "doc": "Creation date",
          "type": "lazy java.util.Date"
        },
        {
          "name": "priority",
          "doc": "The priority of this Greeting",
          "type": "com.example.PriorityLevel",
          "since": "0.3.0",
          "default": "com.example.PriorityLevel.Medium"
        },
        {
          "name": "author",
          "doc": "The author of the Greeting",
          "type": "String"
        }
      ]
    },
    {
      "name": "PriorityLevel",
      "namespace": "com.example",
      "target": "Scala",
      "type": "enumeration",
      "doc": "Priority levels",

      "types": [
        "Low",
        {
          "name": "Medium",
          "doc": "Default priority level"
        },
        "High"
      ]
    }
  ]
}"""

  val completeExampleCodeScala =
    """package com.example
      |/** A greeting interface */
      |sealed abstract class Greetings(
      |  _message: => String,
      |  /** The header of the Greeting */
      |  val header: com.example.GreetingHeader) extends Serializable {
      |  def this(message: => String) = this(message, new com.example.GreetingHeader(new java.util.Date(), "Unknown"))
      |
      |  /**
      |   * The message of the Greeting
      |   * This is a multiline doc comment
      |   */
      |  lazy val message: String = _message
      |  override def equals(o: Any): Boolean = o match {
      |    case x: Greetings => super.equals(o) // We have lazy members, so use object identity to avoid circularity.
      |    case _ => false
      |  }
      |  override def hashCode: Int = {
      |    super.hashCode // Avoid evaluating lazy members in hashCode to avoid circularity.
      |  }
      |  override def toString: String = {
      |    super.toString // Avoid evaluating lazy members in toString to avoid circularity.
      |  }
      |}
      |
      |/** A Greeting in its simplest form */
      |final class SimpleGreeting(
      |  message: => String,
      |  header: com.example.GreetingHeader) extends com.example.Greetings(message, header) {
      |  def this(message: => String) = this(message, new com.example.GreetingHeader(new java.util.Date(), "Unknown"))
      |
      |  override def equals(o: Any): Boolean = o match {
      |    case x: SimpleGreeting => super.equals(o) // We have lazy members, so use object identity to avoid circularity.
      |    case _ => false
      |  }
      |  override def hashCode: Int = {
      |    super.hashCode // Avoid evaluating lazy members in hashCode to avoid circularity.
      |  }
      |  override def toString: String = {
      |    super.toString // Avoid evaluating lazy members in toString to avoid circularity.
      |  }
      |  private[this] def copy(message: => String = message, header: com.example.GreetingHeader = header): SimpleGreeting = {
      |    new SimpleGreeting(message, header)
      |  }
      |  def withMessage(message: => String): SimpleGreeting = {
      |    copy(message = message)
      |  }
      |  def withHeader(header: com.example.GreetingHeader): SimpleGreeting = {
      |    copy(header = header)
      |  }
      |}
      |
      |object SimpleGreeting {
      |  def apply(message: => String): SimpleGreeting = new SimpleGreeting(message, new com.example.GreetingHeader(new java.util.Date(), "Unknown"))
      |  def apply(message: => String, header: com.example.GreetingHeader): SimpleGreeting = new SimpleGreeting(message, header)
      |}
      |
      |/** A Greeting with attachments */
      |final class GreetingWithAttachments(
      |  /** The files attached to the greeting */
      |  val attachments: Vector[java.io.File],
      |  message: => String,
      |  header: com.example.GreetingHeader) extends com.example.Greetings(message, header) {
      |  def this(attachments: Vector[java.io.File], message: => String) = this(attachments, message, new com.example.GreetingHeader(new java.util.Date(), "Unknown"))
      |
      |  override def equals(o: Any): Boolean = o match {
      |    case x: GreetingWithAttachments => super.equals(o) // We have lazy members, so use object identity to avoid circularity.
      |    case _ => false
      |  }
      |  override def hashCode: Int = {
      |    super.hashCode // Avoid evaluating lazy members in hashCode to avoid circularity.
      |  }
      |  override def toString: String = {
      |    super.toString // Avoid evaluating lazy members in toString to avoid circularity.
      |  }
      |  private[this] def copy(attachments: Vector[java.io.File] = attachments, message: => String = message, header: com.example.GreetingHeader = header): GreetingWithAttachments = {
      |    new GreetingWithAttachments(attachments, message, header)
      |  }
      |  def withAttachments(attachments: Vector[java.io.File]): GreetingWithAttachments = {
      |    copy(attachments = attachments)
      |  }
      |  def withMessage(message: => String): GreetingWithAttachments = {
      |    copy(message = message)
      |  }
      |  def withHeader(header: com.example.GreetingHeader): GreetingWithAttachments = {
      |    copy(header = header)
      |  }
      |}
      |
      |object GreetingWithAttachments {
      |  def apply(attachments: Vector[java.io.File], message: => String): GreetingWithAttachments = new GreetingWithAttachments(attachments, message, new com.example.GreetingHeader(new java.util.Date(), "Unknown"))
      |  def apply(attachments: Vector[java.io.File], message: => String, header: com.example.GreetingHeader): GreetingWithAttachments = new GreetingWithAttachments(attachments, message, header)
      |}
      |
      |/** Meta information of a Greeting */
      |final class GreetingHeader(
      |  _created: => java.util.Date,
      |  /** The priority of this Greeting */
      |  val priority: com.example.PriorityLevel,
      |  /** The author of the Greeting */
      |  val author: String) extends Serializable {
      |  def this(created: => java.util.Date, author: String) = this(created, com.example.PriorityLevel.Medium, author)
      |
      |  /** Creation date */
      |  lazy val created: java.util.Date = _created
      |  override def equals(o: Any): Boolean = o match {
      |    case x: GreetingHeader => super.equals(o) // We have lazy members, so use object identity to avoid circularity.
      |    case _ => false
      |  }
      |  override def hashCode: Int = {
      |    super.hashCode // Avoid evaluating lazy members in hashCode to avoid circularity.
      |  }
      |  override def toString: String = {
      |    super.toString // Avoid evaluating lazy members in toString to avoid circularity.
      |  }
      |  private[this] def copy(created: => java.util.Date = created, priority: com.example.PriorityLevel = priority, author: String = author): GreetingHeader = {
      |    new GreetingHeader(created, priority, author)
      |  }
      |  def withCreated(created: => java.util.Date): GreetingHeader = {
      |    copy(created = created)
      |  }
      |  def withPriority(priority: com.example.PriorityLevel): GreetingHeader = {
      |    copy(priority = priority)
      |  }
      |  def withAuthor(author: String): GreetingHeader = {
      |    copy(author = author)
      |  }
      |}
      |
      |object GreetingHeader {
      |  def apply(created: => java.util.Date, author: String): GreetingHeader = new GreetingHeader(created, com.example.PriorityLevel.Medium, author)
      |  def apply(created: => java.util.Date, priority: com.example.PriorityLevel, author: String): GreetingHeader = new GreetingHeader(created, priority, author)
      |}
      |
      |/** Priority levels */
      |sealed abstract class PriorityLevel extends Serializable
      |object PriorityLevel {
      |
      |  case object Low extends PriorityLevel
      |  /** Default priority level */
      |  case object Medium extends PriorityLevel
      |
      |  case object High extends PriorityLevel
      |}""".stripMargin

  val completeExampleCodeJava =
    Map(
      new File("com/example/GreetingHeader.java") ->
        """package com.example;
          |/** Meta information of a Greeting */
          |public final class GreetingHeader implements java.io.Serializable {
          |
          |    /** Creation date */
          |    private com.example.MyLazy<java.util.Date> created;
          |    /** The priority of this Greeting */
          |    private com.example.PriorityLevel priority;
          |    /** The author of the Greeting */
          |    private String author;
          |
          |    public GreetingHeader(com.example.MyLazy<java.util.Date> _created, String _author) {
          |        super();
          |        created = _created;
          |        priority = com.example.PriorityLevel.Medium;
          |        author = _author;
          |    }
          |
          |    public GreetingHeader(com.example.MyLazy<java.util.Date> _created, com.example.PriorityLevel _priority, String _author) {
          |        super();
          |        created = _created;
          |        priority = _priority;
          |        author = _author;
          |    }
          |
          |    public java.util.Date created() {
          |        return this.created.get();
          |    }
          |
          |    public com.example.PriorityLevel priority() {
          |        return this.priority;
          |    }
          |
          |    public String author() {
          |        return this.author;
          |    }
          |
          |    public GreetingHeader withCreated(com.example.MyLazy<java.util.Date> created) {
          |        return new GreetingHeader(created, priority, author);
          |    }
          |
          |    public GreetingHeader withPriority(com.example.PriorityLevel priority) {
          |        return new GreetingHeader(created, priority, author);
          |    }
          |
          |    public GreetingHeader withAuthor(String author) {
          |        return new GreetingHeader(created, priority, author);
          |    }
          |
          |    public boolean equals(Object obj) {
          |        return this == obj; // We have lazy members, so use object identity to avoid circularity.
          |    }
          |
          |    public int hashCode() {
          |        return super.hashCode(); // Avoid evaluating lazy members in hashCode to avoid circularity.
          |    }
          |
          |    public String toString() {
          |        return super.toString(); // Avoid evaluating lazy members in toString to avoid circularity.
          |    }
          |}""".stripMargin,

      new File("com/example/PriorityLevel.java") ->
        """package com.example;
          |/** Priority levels */
          |public enum PriorityLevel {
          |    Low,
          |    /** Default priority level */
          |    Medium,
          |    High
          |}""".stripMargin,

      new File("com/example/GreetingWithAttachments.java") ->
        """package com.example;
          |/** A Greeting with attachments */
          |public final class GreetingWithAttachments extends com.example.Greetings {
          |
          |    /** The files attached to the greeting */
          |    private java.io.File[] attachments;
          |
          |    public GreetingWithAttachments(java.io.File[] _attachments, com.example.MyLazy<String> _message) {
          |        super(_message, new com.example.GreetingHeader(new java.util.Date(), "Unknown"));
          |        attachments = _attachments;
          |    }
          |
          |    public GreetingWithAttachments(java.io.File[] _attachments, com.example.MyLazy<String> _message, com.example.GreetingHeader _header) {
          |        super(_message, _header);
          |        attachments = _attachments;
          |    }
          |
          |    public java.io.File[] attachments() {
          |        return this.attachments;
          |    }
          |
          |    public GreetingWithAttachments withAttachments(java.io.File[] attachments) {
          |        return new GreetingWithAttachments(attachments, new com.example.MyLazy<String>() { public String get() { return message(); } }, header());
          |    }
          |
          |    public GreetingWithAttachments withMessage(com.example.MyLazy<String> message) {
          |        return new GreetingWithAttachments(attachments, message, header());
          |    }
          |
          |    public GreetingWithAttachments withHeader(com.example.GreetingHeader header) {
          |        return new GreetingWithAttachments(attachments, new com.example.MyLazy<String>() { public String get() { return message(); } }, header);
          |    }
          |
          |    public boolean equals(Object obj) {
          |        return this == obj; // We have lazy members, so use object identity to avoid circularity.
          |    }
          |
          |    public int hashCode() {
          |        return super.hashCode(); // Avoid evaluating lazy members in hashCode to avoid circularity.
          |    }
          |
          |    public String toString() {
          |        return super.toString(); // Avoid evaluating lazy members in toString to avoid circularity.
          |    }
          |}""".stripMargin,

      new File("com/example/Greetings.java") ->
        """package com.example;
          |/** A greeting interface */
          |public abstract class Greetings implements java.io.Serializable {
          |
          |    /**
          |     * The message of the Greeting
          |     * This is a multiline doc comment
          |     */
          |    private com.example.MyLazy<String> message;
          |    /** The header of the Greeting */
          |    private com.example.GreetingHeader header;
          |
          |    public Greetings(com.example.MyLazy<String> _message) {
          |        super();
          |        message = _message;
          |        header = new com.example.GreetingHeader(new java.util.Date(), "Unknown");
          |    }
          |
          |    public Greetings(com.example.MyLazy<String> _message, com.example.GreetingHeader _header) {
          |        super();
          |        message = _message;
          |        header = _header;
          |    }
          |
          |    public String message() {
          |        return this.message.get();
          |    }
          |
          |    public com.example.GreetingHeader header() {
          |        return this.header;
          |    }
          |
          |    public boolean equals(Object obj) {
          |        return this == obj; // We have lazy members, so use object identity to avoid circularity.
          |    }
          |
          |    public int hashCode() {
          |        return super.hashCode(); // Avoid evaluating lazy members in hashCode to avoid circularity.
          |    }
          |
          |    public String toString() {
          |        return super.toString(); // Avoid evaluating lazy members in toString to avoid circularity.
          |    }
          |}""".stripMargin,

      new File("com/example/SimpleGreeting.java") ->
        """package com.example;
          |/** A Greeting in its simplest form */
          |public final class SimpleGreeting extends com.example.Greetings {
          |
          |    public SimpleGreeting(com.example.MyLazy<String> _message) {
          |        super(_message, new com.example.GreetingHeader(new java.util.Date(), "Unknown"));
          |    }
          |
          |    public SimpleGreeting(com.example.MyLazy<String> _message, com.example.GreetingHeader _header) {
          |        super(_message, _header);
          |    }
          |
          |    public SimpleGreeting withMessage(com.example.MyLazy<String> message) {
          |        return new SimpleGreeting(message, header());
          |    }
          |
          |    public SimpleGreeting withHeader(com.example.GreetingHeader header) {
          |        return new SimpleGreeting(new com.example.MyLazy<String>() { public String get() { return message(); } }, header);
          |    }
          |
          |    public boolean equals(Object obj) {
          |        return this == obj; // We have lazy members, so use object identity to avoid circularity.
          |    }
          |
          |    public int hashCode() {
          |        return super.hashCode(); // Avoid evaluating lazy members in hashCode to avoid circularity.
          |    }
          |
          |    public String toString() {
          |        return super.toString(); // Avoid evaluating lazy members in toString to avoid circularity.
          |    }
          |}""".stripMargin)

  val completeExampleCodeCodec =
    """package generated
      |import _root_.sjsonnew.{ deserializationError, serializationError, Builder, JsonFormat, Unbuilder }
      |trait GreetingsFormats { self: generated.GreetingHeaderFormats with generated.GreetingWithAttachmentsFormats with java.io.FileFormats with generated.SimpleGreetingFormats with sjsonnew.BasicJsonProtocol =>
      |implicit lazy val GreetingsFormat: JsonFormat[com.example.Greetings] = unionFormat2[com.example.Greetings, com.example.SimpleGreeting, com.example.GreetingWithAttachments]
      |}
      |package generated
      |import _root_.sjsonnew.{ deserializationError, serializationError, Builder, JsonFormat, Unbuilder }
      |trait SimpleGreetingFormats { self: sjsonnew.BasicJsonProtocol with generated.GreetingHeaderFormats =>
      |implicit lazy val SimpleGreetingFormat: JsonFormat[com.example.SimpleGreeting] = new JsonFormat[com.example.SimpleGreeting] {
      |  override def read[J](jsOpt: Option[J], unbuilder: Unbuilder[J]): com.example.SimpleGreeting = {
      |    jsOpt match {
      |      case Some(js) =>
      |      unbuilder.beginObject(js)
      |      val message = unbuilder.readField[String]("message")
      |      val header = unbuilder.readField[com.example.GreetingHeader]("header")
      |      unbuilder.endObject()
      |      new com.example.SimpleGreeting(message, header)
      |      case None =>
      |      deserializationError("Expected JsObject but found None")
      |    }
      |  }
      |  override def write[J](obj: com.example.SimpleGreeting, builder: Builder[J]): Unit = {
      |    builder.beginObject()
      |    builder.addField("message", obj.message)
      |    builder.addField("header", obj.header)
      |    builder.endObject()
      |  }
      |}
      |}
      |package generated
      |import _root_.sjsonnew.{ deserializationError, serializationError, Builder, JsonFormat, Unbuilder }
      |trait GreetingWithAttachmentsFormats { self: java.io.FileFormats with sjsonnew.BasicJsonProtocol with generated.GreetingHeaderFormats =>
      |implicit lazy val GreetingWithAttachmentsFormat: JsonFormat[com.example.GreetingWithAttachments] = new JsonFormat[com.example.GreetingWithAttachments] {
      |  override def read[J](jsOpt: Option[J], unbuilder: Unbuilder[J]): com.example.GreetingWithAttachments = {
      |    jsOpt match {
      |      case Some(js) =>
      |      unbuilder.beginObject(js)
      |      val attachments = unbuilder.readField[Vector[java.io.File]]("attachments")
      |      val message = unbuilder.readField[String]("message")
      |      val header = unbuilder.readField[com.example.GreetingHeader]("header")
      |      unbuilder.endObject()
      |      new com.example.GreetingWithAttachments(attachments, message, header)
      |      case None =>
      |      deserializationError("Expected JsObject but found None")
      |    }
      |  }
      |  override def write[J](obj: com.example.GreetingWithAttachments, builder: Builder[J]): Unit = {
      |    builder.beginObject()
      |    builder.addField("attachments", obj.attachments)
      |    builder.addField("message", obj.message)
      |    builder.addField("header", obj.header)
      |    builder.endObject()
      |  }
      |}
      |}
      |package generated
      |import _root_.sjsonnew.{ deserializationError, serializationError, Builder, JsonFormat, Unbuilder }
      |trait GreetingHeaderFormats { self: java.util.DateFormats with sjsonnew.BasicJsonProtocol with generated.PriorityLevelFormats =>
      |implicit lazy val GreetingHeaderFormat: JsonFormat[com.example.GreetingHeader] = new JsonFormat[com.example.GreetingHeader] {
      |  override def read[J](jsOpt: Option[J], unbuilder: Unbuilder[J]): com.example.GreetingHeader = {
      |    jsOpt match {
      |      case Some(js) =>
      |      unbuilder.beginObject(js)
      |      val created = unbuilder.readField[java.util.Date]("created")
      |      val priority = unbuilder.readField[com.example.PriorityLevel]("priority")
      |      val author = unbuilder.readField[String]("author")
      |      unbuilder.endObject()
      |      new com.example.GreetingHeader(created, priority, author)
      |      case None =>
      |      deserializationError("Expected JsObject but found None")
      |    }
      |  }
      |  override def write[J](obj: com.example.GreetingHeader, builder: Builder[J]): Unit = {
      |    builder.beginObject()
      |    builder.addField("created", obj.created)
      |    builder.addField("priority", obj.priority)
      |    builder.addField("author", obj.author)
      |    builder.endObject()
      |  }
      |}
      |}
      |package generated
      |import _root_.sjsonnew.{ deserializationError, serializationError, Builder, JsonFormat, Unbuilder }
      |trait PriorityLevelFormats { self: sjsonnew.BasicJsonProtocol =>
      |implicit lazy val PriorityLevelFormat: JsonFormat[com.example.PriorityLevel] = new JsonFormat[com.example.PriorityLevel] {
      |  override def read[J](jsOpt: Option[J], unbuilder: Unbuilder[J]): com.example.PriorityLevel = {
      |    jsOpt match {
      |      case Some(js) =>
      |      unbuilder.readString(js) match {
      |        case "Low" => com.example.PriorityLevel.Low
      |        case "Medium" => com.example.PriorityLevel.Medium
      |        case "High" => com.example.PriorityLevel.High
      |      }
      |      case None =>
      |      deserializationError("Expected JsString but found None")
      |    }
      |  }
      |  override def write[J](obj: com.example.PriorityLevel, builder: Builder[J]): Unit = {
      |    val str = obj match {
      |      case com.example.PriorityLevel.Low => "Low"
      |      case com.example.PriorityLevel.Medium => "Medium"
      |      case com.example.PriorityLevel.High => "High"
      |    }
      |    builder.writeString(str)
      |  }
      |}
      |}
      |package generated
      |trait CustomProtcol extends generated.GreetingsFormats with generated.GreetingHeaderFormats with generated.PriorityLevelFormats with java.util.DateFormats with generated.GreetingWithAttachmentsFormats with java.io.FileFormats with generated.SimpleGreetingFormats with sjsonnew.BasicJsonProtocol
      |object CustomProtcol extends CustomProtcol""".stripMargin


  val growableAddOneFieldExample = """{
  "name": "growableAddOneField",
  "target": "Scala",
  "type": "record",
  "fields": [
    {
      "name": "field",
      "type": "int",
      "since": "0.1.0",
      "default": "0"
    }
  ]
}""".stripMargin

  val multiLineDocExample =
    """{
      |  "name": "multiLineDocField",
      |  "type": "int",
      |  "doc": [
      |    "A field whose documentation",
      |    "spans over multiple lines"
      |  ]
      |}""".stripMargin

}
