(defproject heion "1.0.0-SNAPSHOT"
  :description "Clojure Dropwizard"
  :dependencies [[org.clojure/clojure "1.3.0-jblomo"]
                 [com.yammer.dropwizard/dropwizard-core "0.3.1"]]
  ;:java-source-path "src/main/java"
  ; specify ordering
  :aot [#"heion.resources.*" #"heion.*"])
