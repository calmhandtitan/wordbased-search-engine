This is our first implementation of our search engine with regex.

It only works for http pages, (not for https) , so we took our college website as seed.

The interface is simple.

On background crawler runs and saves data to a HashMap of HashMap.

Any regular expression query can be done  and will yield the webpages containing the matches.

Proxy settings are hard coded into code.

Lots of bugs to be resolved. 

Further work include replacing the HashSet with a database(the model) and putting limit on memory usage.and several other things.

