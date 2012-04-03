(ns heion.resources.HelloWorldResource
  (:import [com.google.common.base Optional]
           [com.yammer.metrics.annotation Timed]
           [javax.ws.rs GET]
           [javax.ws.rs Path]
           [javax.ws.rs Produces]
           [javax.ws.rs QueryParam]
           [javax.ws.rs.core MediaType]
           [java.util.concurrent.atomic AtomicLong])
  (:gen-class :name ^{javax.ws.rs.Path "/hello-world"
                      javax.ws.rs.Produces ["application/json"] #_javax.ws.rs.core.MediaType/APPLICATION_JSON}
              heion.resources.HelloWorldResource
              :state state
              :init init
              :constructors {[String String] []}
              :methods [[^{javax.ws.rs.GET {} com.yammer.metrics.annotation.Timed {}} sayHello
                         [^{javax.ws.rs.QueryParam "name" :parameters String} com.google.common.base.Optional]
                         
                         java.util.Map]]))

(defn -init
  [template default-name]
  [[] {:template template :default-name default-name :counter (AtomicLong.)}])

(defn -sayHello
  [this name]
  {:id (.incrementAndGet (:counter (.state this)))
   :content (format (:template (.state this))
                   (.or name (:default-name (.state this))))})
