// "Replace with text block" "true"

class TextBlockMigration {

  void concatenationWithSpacesAtTheBeginning() {
      /*1*/
      String body =/*3*/ """
                <body>
                  <p>
                  </p>
                </body>\
              """/*2*/;/*4*/
  }

}