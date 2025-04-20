using Aspectos_Operaciones_BasesDeDatos.Interfaces;
using Castle.DynamicProxy;
using Aspectos_Operaciones_BasesDeDatos.Clases;
using Aspectos_Operaciones_BasesDeDatos.Aspectos;

try
{
    //Generador del proxy
    var generador_proxy = new ProxyGenerator();

    //Creación del proxy dinámico para usar los aspectos
    IOperacionesBaseDeDatos mi_proxy_microsoft = generador_proxy.CreateInterfaceProxyWithTarget(typeof(IOperacionesBaseDeDatos), new OperarBaseDeDatosMicrosoft(), new InterceptorOperacionesBasesDeDatos()) as IOperacionesBaseDeDatos;
    IOperacionesBaseDeDatos mi_proxy_posgress = generador_proxy.CreateInterfaceProxyWithTarget(typeof(IOperacionesBaseDeDatos), new OperarBaseDeDatosPosgress(), new InterceptorOperacionesBasesDeDatos()) as IOperacionesBaseDeDatos;
    IOperacionesBaseDeDatos mi_proxy_oracle = generador_proxy.CreateInterfaceProxyWithTarget(typeof(IOperacionesBaseDeDatos), new OperarBaseDeDatosOracle(), new InterceptorOperacionesBasesDeDatos()) as IOperacionesBaseDeDatos;

    //Usar el proxy
    mi_proxy_microsoft.Crear();
    Console.WriteLine("");
    mi_proxy_posgress.Eliminar();
    Console.WriteLine("");
    mi_proxy_oracle.Leer();
}
catch (Exception error)
{
    Console.WriteLine(error.ToString());
}