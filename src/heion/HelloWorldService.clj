(ns heion.HelloWorldService
  (:import [heion HelloWorldConfiguration]
           [heion.resources HelloWorldResource]
           [heion.health TemplateHealthCheck]
           [com.yammer.dropwizard.config Environment])
  (:gen-class :extends ^{:parameters [heion.HelloWorldConfiguration]} com.yammer.dropwizard.Service
              :init init
              :constructors {[] [String]}
              :main true))

(defn -init
  "Initialize service with hello-world config"
  [& args]
  [["hello-world"] nil])

(defn -main
  "Start HelloWorld Service"
  [& args]
  (.run (heion.HelloWorldService.) args))

(defn -initialize
  "Override default service initialization"
  [this configuration environment]
  (doto environment
    (.addResource (HelloWorldResource.
                    (.get-template configuration)
                    (.get-default-name configuration)))
    (.addHealthCheck (TemplateHealthCheck. (.get-template configuration)))))
