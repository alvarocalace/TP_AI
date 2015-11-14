/**
 * WSProcVentaBeanServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ws.ventas;

import config.Config;

public class WSProcVentaBeanServiceLocator extends org.apache.axis.client.Service implements ws.ventas.WSProcVentaBeanService {

    public WSProcVentaBeanServiceLocator() {
    }


    public WSProcVentaBeanServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WSProcVentaBeanServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WSProcVentaBeanPort
    private java.lang.String WSProcVentaBeanPort_address = Config.getSetting("ws_ventas_url");//http://localhost:8080/TP_AIWEB/WSProcVentaBean";

    public java.lang.String getWSProcVentaBeanPortAddress() {
        return WSProcVentaBeanPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WSProcVentaBeanPortWSDDServiceName = "WSProcVentaBeanPort";

    public java.lang.String getWSProcVentaBeanPortWSDDServiceName() {
        return WSProcVentaBeanPortWSDDServiceName;
    }

    public void setWSProcVentaBeanPortWSDDServiceName(java.lang.String name) {
        WSProcVentaBeanPortWSDDServiceName = name;
    }

    public ws.ventas.WSProcVentaBean getWSProcVentaBeanPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WSProcVentaBeanPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWSProcVentaBeanPort(endpoint);
    }

    public ws.ventas.WSProcVentaBean getWSProcVentaBeanPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ws.ventas.WSProcVentaBeanServiceSoapBindingStub _stub = new ws.ventas.WSProcVentaBeanServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getWSProcVentaBeanPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWSProcVentaBeanPortEndpointAddress(java.lang.String address) {
        WSProcVentaBeanPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (ws.ventas.WSProcVentaBean.class.isAssignableFrom(serviceEndpointInterface)) {
                ws.ventas.WSProcVentaBeanServiceSoapBindingStub _stub = new ws.ventas.WSProcVentaBeanServiceSoapBindingStub(new java.net.URL(WSProcVentaBeanPort_address), this);
                _stub.setPortName(getWSProcVentaBeanPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("WSProcVentaBeanPort".equals(inputPortName)) {
            return getWSProcVentaBeanPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ventas.ws/", "WSProcVentaBeanService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ventas.ws/", "WSProcVentaBeanPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WSProcVentaBeanPort".equals(portName)) {
            setWSProcVentaBeanPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
