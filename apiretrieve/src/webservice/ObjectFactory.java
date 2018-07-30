
package webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the webservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FetchDepartments_QNAME = new QName("http://WebService/", "fetchDepartments");
    private final static QName _FetchDepartmentsResponse_QNAME = new QName("http://WebService/", "fetchDepartmentsResponse");
    private final static QName _FetchStaffResponse_QNAME = new QName("http://WebService/", "fetchStaffResponse");
    private final static QName _Departments_QNAME = new QName("http://WebService/", "departments");
    private final static QName _Staff_QNAME = new QName("http://WebService/", "staff");
    private final static QName _FetchStaff_QNAME = new QName("http://WebService/", "fetchStaff");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FetchStaff }
     * 
     */
    public FetchStaff createFetchStaff() {
        return new FetchStaff();
    }

    /**
     * Create an instance of {@link Staff }
     * 
     */
    public Staff createStaff() {
        return new Staff();
    }

    /**
     * Create an instance of {@link Departments }
     * 
     */
    public Departments createDepartments() {
        return new Departments();
    }

    /**
     * Create an instance of {@link FetchStaffResponse }
     * 
     */
    public FetchStaffResponse createFetchStaffResponse() {
        return new FetchStaffResponse();
    }

    /**
     * Create an instance of {@link FetchDepartmentsResponse }
     * 
     */
    public FetchDepartmentsResponse createFetchDepartmentsResponse() {
        return new FetchDepartmentsResponse();
    }

    /**
     * Create an instance of {@link FetchDepartments }
     * 
     */
    public FetchDepartments createFetchDepartments() {
        return new FetchDepartments();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FetchDepartments }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "fetchDepartments")
    public JAXBElement<FetchDepartments> createFetchDepartments(FetchDepartments value) {
        return new JAXBElement<FetchDepartments>(_FetchDepartments_QNAME, FetchDepartments.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FetchDepartmentsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "fetchDepartmentsResponse")
    public JAXBElement<FetchDepartmentsResponse> createFetchDepartmentsResponse(FetchDepartmentsResponse value) {
        return new JAXBElement<FetchDepartmentsResponse>(_FetchDepartmentsResponse_QNAME, FetchDepartmentsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FetchStaffResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "fetchStaffResponse")
    public JAXBElement<FetchStaffResponse> createFetchStaffResponse(FetchStaffResponse value) {
        return new JAXBElement<FetchStaffResponse>(_FetchStaffResponse_QNAME, FetchStaffResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Departments }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "departments")
    public JAXBElement<Departments> createDepartments(Departments value) {
        return new JAXBElement<Departments>(_Departments_QNAME, Departments.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Staff }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "staff")
    public JAXBElement<Staff> createStaff(Staff value) {
        return new JAXBElement<Staff>(_Staff_QNAME, Staff.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FetchStaff }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "fetchStaff")
    public JAXBElement<FetchStaff> createFetchStaff(FetchStaff value) {
        return new JAXBElement<FetchStaff>(_FetchStaff_QNAME, FetchStaff.class, null, value);
    }

}
