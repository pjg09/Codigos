//Clase proxy

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Castle.DynamicProxy; //Esta biblioteca tiene interfaces 

namespace Aspectos_Operaciones_BasesDeDatos.Aspectos
{
    public class InterceptorOperacionesBasesDeDatos : IInterceptor
    {
        //Metodo intercept de la biblioteca importada (Dynamic proxy)
        void IInterceptor.Intercept(IInvocation llamado)
        {
            //Escribo quien llama o quien invoca al proxy
            Console.WriteLine($"El método que está llamando es: {llamado.Method.Name}");

            //Se ejecuta el método que se está llamando por medio del Proceed
            llamado.Proceed();

            //Escribo el resultado de la invocación
            Console.WriteLine($"El método {llamado.Method.Name} se ejecutó exitosamente");
        }
    }
}
