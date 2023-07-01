/**
 * @param {integer} init
 * @return { increment: Function, decrement: Function, reset: Function }
 */
var createCounter = function(init) {
    var x=init;
    return{
        increment:function(){
            x++;
            return x;
        },
    
         decrement:function(){
            x--;
             return x;
        },
          
         reset:function(){
            x=init;
             return x;
        }
    
    }
};

/**
 * const counter = createCounter(5)
 * counter.increment(); // 6
 * counter.reset(); // 5
 * counter.decrement(); // 4
 */