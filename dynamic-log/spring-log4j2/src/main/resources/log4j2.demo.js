var reader = new java.io.StringReader(property.getString());
var p = new java.util.Properties();
p.load(reader);
var s=p.entrySet().iterator();
while(s.hasNext()){
    var k=s.next();
    var levelName = k.getValue();
    if (levelName == null || levelName == "") {
        levelName = "INFO";
    }
    var level = org.apache.logging.log4j.Level.toLevel(levelName);
    var loggerContextFactory = org.apache.logging.log4j.LogManager.getFactory();
    var logger = org.apache.logging.log4j.LogManager.getLogger(k.getKey(), loggerContextFactory);
//    var logger = org.apache.logging.log4j.LogManager.getLogger(k.getKey());
    logger.setLevel(level);
}

