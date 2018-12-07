import Foundation


struct Memo {
    
    let id: Int32
    let title: String
    let content: String
    let createdAt: Int64
    let lastModifiedAt: Int64
    
    var description: String {
        let date = Date(timeIntervalSince1970: Double(self.createdAt))
        return ("\(self.title)\n\(self.content)\n\(date)")
    }
    
}
